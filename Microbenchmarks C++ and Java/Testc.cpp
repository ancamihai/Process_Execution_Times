#include<iostream>                         
#include<fstream>   
#include <chrono>
#include <thread>
#include <condition_variable>
#include <windows.h>

using namespace std;
using namespace std::chrono;

std::mutex my_lock;
int shared_variable = 0;

double durationThreadMigration;

double staticAllocation()
{
	auto startTime = high_resolution_clock::now();

	for (int i = 0; i < 1000; i++)
	{
		int x = 5;
	}

	auto endTime = high_resolution_clock::now();

	auto duration = duration_cast<nanoseconds> (endTime - startTime);

	double durationCast = static_cast<double>(duration.count());

	return durationCast;
}

double staticAccess()
{
	int x = 5;
	int y = 6;

	auto startTime = high_resolution_clock::now();

	for (int i = 0; i < 1000; i++)
	{
		y = x;
	}

	auto endTime = high_resolution_clock::now();

	auto duration = duration_cast<nanoseconds> (endTime - startTime);

	double durationCast = static_cast<double>(duration.count());

	return durationCast;
}


double dynamicAllocation()
{
	auto startTime = high_resolution_clock::now();

	for (int i = 0; i < 1000; i++)
	{
		int* array = new int[5];
	}

	auto endTime = high_resolution_clock::now();

	auto duration = duration_cast<nanoseconds> (endTime - startTime);

	double durationCast = static_cast<double>(duration.count());

	return durationCast;
}


double dynamicAccess()
{
	int* array = new int[5];
	array[0] = 5;
	int x = 6;


	auto startTime = high_resolution_clock::now();

	for (int i = 0; i < 1000; i++)
	{
		x = array[0];
	}

	auto endTime = high_resolution_clock::now();

	auto duration = duration_cast<nanoseconds> (endTime - startTime);

	double durationCast = static_cast<double>(duration.count());

	return durationCast;
}

void threadCreateFunction()
{
	int x = 5;
}

double threadCreate()
{
	auto startTime = high_resolution_clock::now();

	std::thread myThread(threadCreateFunction);

	auto endTime = high_resolution_clock::now();

	myThread.join();

	auto duration = duration_cast<nanoseconds> (endTime - startTime);

	double durationCast = static_cast<double>(duration.count());

	return durationCast;
}

void contextSwitchFunction()
{   
	my_lock.lock();
	shared_variable++;
	my_lock.unlock();
}

double threadContextSwitch()
{     
	auto startTime = high_resolution_clock::now();

	std::thread myThreads[25];

	for (int i = 0; i < 25; i++)
	{
		 myThreads[i]= thread(contextSwitchFunction);
	}

	for (int i = 0; i < 25; i++)
	{
		myThreads[i].join();
	}

	auto endTime = high_resolution_clock::now();

	auto duration = duration_cast<nanoseconds> (endTime - startTime);

	double durationCast = static_cast<double>(duration.count());

	return durationCast/25;
}

void threadMigrationFunction()
{
	auto startTime = high_resolution_clock::now();
	shared_variable++;
	DWORD_PTR dw = SetThreadAffinityMask(GetCurrentThread(), DWORD_PTR(1) << 1);
	shared_variable++;
	auto endTime = high_resolution_clock::now();
	auto duration = duration_cast<nanoseconds> (endTime - startTime);

	durationThreadMigration = static_cast<double>(duration.count());
}

double threadMigration()
{
	std::thread myThread;

	myThread=thread(threadMigrationFunction);
    
	myThread.join();

	return durationThreadMigration;
}



int main(int argc, char** argv)
{
	if (strcmp(argv[1], "staticAllocation") == 0)
	{
		double dataOut[100];
		int nrConsidered = 0;
		double average = 0;
		for (int i = 0; i < 100; i++)
		{
			dataOut[i] = staticAllocation() / 1000;
		}
		for (int i = 0; i < 100; i++)
		{
			if (dataOut[i] <= 0.7)
			{
				average += dataOut[i];
				nrConsidered++;
			}
		}
		fstream FileName;
		FileName.open(".//Results//staticAllocation.txt", ios::out);
		if (!FileName) {
			cout << " Error while creating the file ";
		}
		else {
			FileName << "C++:\n";
			for (int i = 0; i < 100; i++)
			{
				FileName << dataOut[i] << "\n";
			}
			FileName << "Average:\n";
			if (nrConsidered == 0)
			{
				FileName << 0<<"\n\n";
			}
			else
			{
				FileName << (average / nrConsidered)<<"\n\n";
			}
			FileName.close();
		}

	}

	else if (strcmp(argv[1], "staticAccess") == 0)
	{
		double dataOut[100];
		int nrConsidered = 0;
		double average = 0;
		for (int i = 0; i < 100; i++)
		{
			dataOut[i] = staticAccess() / 1000;
		}
		for (int i = 0; i < 100; i++)
		{
			if (dataOut[i] <= 0.7)
			{
				average += dataOut[i];
				nrConsidered++;
			}
		}
		fstream FileName;
		FileName.open(".//Results//staticAccess.txt", ios::out);
		if (!FileName) {
			cout << " Error while creating the file ";
		}
		else {
			FileName << "C++:\n";
			for (int i = 0; i < 100; i++)
			{
				FileName << dataOut[i] << "\n";
			}
			FileName << "Average:\n";
			if (nrConsidered == 0)
			{
				FileName << 0<<"\n\n";
			}
			else
			{
				FileName << (average / nrConsidered)<<"\n\n";
			}
			FileName.close();
		}

	}

	else if (strcmp(argv[1], "dynamicAllocation") == 0)
	{
		double dataOut[100];
		int nrConsidered = 0;
		double average = 0;
		for (int i = 0; i < 100; i++)
		{
			dataOut[i] = dynamicAllocation() / 1000;
		}
		for (int i = 0; i < 100; i++)
		{
			if (dataOut[i] <= 115)
			{
				average += dataOut[i];
				nrConsidered++;
			}
		}
		fstream FileName;
		FileName.open(".//Results//dynamicAllocation.txt", ios::out);
		if (!FileName) {
			cout << " Error while creating the file ";
		}
		else {
			FileName << "C++:\n";
			for (int i = 0; i < 100; i++)
			{
				FileName << dataOut[i] << "\n";
			}
			FileName << "Average:\n";
			if (nrConsidered == 0)
			{
				FileName << 0<<"\n\n";
			}
			else
			{
				FileName << (average / nrConsidered)<<"\n\n";
			}
			FileName.close();
		}

	}

	else if (strcmp(argv[1], "dynamicAccess") == 0)
	{
	double dataOut[100];
	int nrConsidered = 0;
	double average = 0;
	for (int i = 0; i < 100; i++)
	{
		dataOut[i] = dynamicAccess() / 1000;
	}
	for (int i = 0; i < 100; i++)
	{
		if (dataOut[i] <= 0.9)
		{
			average += dataOut[i];
			nrConsidered++;
		}
	}
	fstream FileName;
	FileName.open(".//Results//dynamicAccess.txt", ios::out);
	if (!FileName) {
		cout << " Error while creating the file ";
	}
	else {
		FileName << "C++:\n";
		for (int i = 0; i < 100; i++)
		{
			FileName << dataOut[i] << "\n";
		}
		FileName << "Average:\n";
		if (nrConsidered == 0)
		{
			FileName << 0<<"\n\n";
		}
		else
		{
			FileName << (average / nrConsidered)<<"\n\n";
		}
		FileName.close();
	}

	}
	else if (strcmp(argv[1], "createThread") == 0)
	{
	double dataOut[100];
	int nrConsidered = 0;
	double average = 0;
	for (int i = 0; i < 100; i++)
	{
		dataOut[i] = threadCreate();
	}
	for (int i = 0; i < 100; i++)
	{
		if (dataOut[i] < 25000)
		{
			average += dataOut[i];
			nrConsidered++;
		}
	}
	fstream FileName;
	FileName.open(".//Results//threadCreation.txt", ios::out);
	if (!FileName) {
		cout << " Error while creating the file ";
	}
	else {
		FileName << "C++:\n";
		for (int i = 0; i < 100; i++)
		{
			FileName << dataOut[i] << "\n";
		}
		FileName << "Average:\n";
		if (nrConsidered == 0)
		{
			FileName << 0<<"\n\n";
		}
		else
		{
			FileName << (average / nrConsidered)<<"\n\n";
		}
		FileName.close();
	}
    }
	else if (strcmp(argv[1], "contextSwitch") == 0)
	{
	double dataOut[100];
	int nrConsidered = 0;
	double average = 0;
	for (int i = 0; i < 100; i++)
	{   
		dataOut[i] = threadContextSwitch();
	}
	for (int i = 0; i < 100; i++)
	{
		if (dataOut[i] <= 45000)
		{
			average += dataOut[i];
			nrConsidered++;
		}
	}
	fstream FileName;
	FileName.open(".//Results//threadContextSwitch.txt", ios::out);
	if (!FileName) {
		cout << " Error while creating the file ";
	}
	else {
		FileName << "C++:\n";
		for (int i = 0; i < 100; i++)
		{
			FileName << dataOut[i] << "\n";
		}
		FileName << "Average:\n";
		if (nrConsidered == 0)
		{
			FileName << 0<<"\n\n";
		}
		else
		{
			FileName << (average / nrConsidered)<<"\n\n";
		}
		FileName.close();
	}

    }
	else if (strcmp(argv[1], "threadMigration") == 0)
	{
	double dataOut[100];
	int nrConsidered = 0;
	double average = 0;
	for (int i = 0; i < 100; i++)
	{
		dataOut[i] = threadMigration();
	}
	for (int i = 0; i < 100; i++)
	{
		if (dataOut[i] < 10000)
		{
			average += dataOut[i];
			nrConsidered++;
		}
	}
	fstream FileName;
	FileName.open(".//Results//threadMigration.txt", ios::out);
	if (!FileName) {
		cout << " Error while creating the file ";
	}
	else {
		FileName << "C++:\n";
		for (int i = 0; i < 100; i++)
		{
			FileName << dataOut[i] << "\n";
		}
		FileName << "Average:\n";
		if (nrConsidered == 0)
		{
			FileName << 0 << "\n\n";
		}
		else
		{
			FileName << (average / nrConsidered) << "\n\n";
		}
		FileName.close();
	}
    }

	return 0;
}