# This is a sample Python script.
import os
# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


import time
import sys
import threading
import psutil

def dynamicAllocation():
    start_time = time.time_ns()
    for i in range(100000):
        x = [0] * 5
    end_time = time.time_ns()
    duration = end_time - start_time
    return duration/100000


def dynamicAccess():
    x = [0] * 5
    start_time = time.time_ns()
    for i in range(100000):
        y = x[0]
    end_time = time.time_ns()
    duration = end_time - start_time
    return duration / 100000

class thread(threading.Thread):
    def __init__(self):
        threading.Thread.__init__(self)
    def run(self):
        x=5

def threadCreate():
    start_time = time.time_ns()
    for i in range(1000):
         myThread=thread()
    end_time = time.time_ns()
    duration = end_time - start_time
    return duration


lock=threading.Lock()
variable=0
class synchronizedThread(threading.Thread):
    def __init__(self):
        threading.Thread.__init__(self)
        self.duration = None
    def run(self):
        global variable
        lock.acquire()
        variable+=1
        lock.release()

def threadContextSwitch():
    threads=[]
    for i in range(25):
        threads.append(synchronizedThread())
    start_time=time.time_ns()
    for i in range(25):
        threads[i].start()
    for i in range(25):
        threads[i].join()
    end_time = time.time_ns()
    duration = (end_time - start_time)
    return duration/25

class migrationThread(threading.Thread):
    def __init__(self):
        threading.Thread.__init__(self)
        self.duration = None
    def run(self):
        variable=0
        pid=os.getpid()
        p = psutil.Process(pid)
        p.cpu_affinity([0])
        variable += 1
        p.cpu_affinity([1])
        variable += 1


def threadMigration():
    threads = []
    for i in range(25):
       threads.append(migrationThread())
    start_time=time.time_ns()
    for i in range(25):
       threads[i].start()
    for i in range(25):
        threads[i].join()
    end_time = time.time_ns()
    duration = (end_time - start_time)
    return duration/25

def main(arg):
    if arg == "dynamicAllocation":
        nrConsidered = 0
        average = 0
        data_out = [0] * 100
        for i in range(100):
            data_out[i] = dynamicAllocation()
        for i in range(100):
            if (data_out[i] < 140):
                average += data_out[i]
                nrConsidered += 1
        file1 = open(".//Results//dynamicAllocation.txt", 'a')
        file1.write("Python:\n")
        for i in range(100):
            file1.write(str(data_out[i]) + "\n")
        file1.write("Average:\n")
        if (nrConsidered != 0):
            file1.write(str(average / nrConsidered))
        else:
            file1.write(str(0))
        file1.close()
    if arg == "dynamicAccess":
        nrConsidered=0
        average=0
        data_out = [0] * 100
        for i in range(100):
            data_out[i] = dynamicAccess()
        for i in range(100):
            if(data_out[i]<42):
                average+=data_out[i]
                nrConsidered+=1
        file1 = open(".//Results//dynamicAccess.txt", 'a')
        file1.write("Python:\n")
        for i in range(100):
            file1.write(str(data_out[i]) + "\n")
        file1.write("Average:\n")
        if(nrConsidered!=0):
            file1.write(str(average/nrConsidered))
        else:
            file1.write(str(0))
        file1.close()
    if arg == "createThread":
        nrConsidered=0
        average=0
        data_out = [0] * 100
        for i in range(100):
            data_out[i] = threadCreate()/1000
        for i in range(100):
            if(data_out[i]<6500):
                average+=data_out[i]
                nrConsidered+=1
        file1 = open(".//Results//threadCreation.txt", 'a')
        file1.write("Python:\n")
        for i in range(100):
            file1.write(str(data_out[i]) + "\n")
        file1.write("Average:\n")
        if(nrConsidered!=0):
            file1.write(str(average/nrConsidered))
        else:
            file1.write(str(0))
        file1.close()
    if arg == "contextSwitch":
        nrConsidered=0
        average=0
        data_out = [0] * 100
        for i in range(100):
            data_out[i] = threadContextSwitch()
        for i in range(100):
            if(data_out[i]< 120000):
                average+=data_out[i]
                nrConsidered+=1
        file1 = open(".//Results//threadContextSwitch.txt", 'a')
        file1.write("Python:\n")
        for i in range(100):
            file1.write(str(data_out[i]) + "\n")
        file1.write("Average:\n")
        if(nrConsidered!=0):
            file1.write(str(average/nrConsidered))
        else:
            file1.write(str(0))
        file1.close()
    if arg == "threadMigration":
        nrConsidered = 0
        average = 0
        data_out = [0] * 100
        for i in range(100):
            data_out[i] = threadMigration()
        for i in range(100):
            if (data_out[i] < 210000):
                average += data_out[i]
                nrConsidered += 1
        file1 = open(".//Results//threadMigration.txt", 'a')
        file1.write("Python:\n")
        for i in range(100):
            file1.write(str(data_out[i]) + "\n")
        file1.write("Average:\n")
        if (nrConsidered != 0):
            file1.write(str(average / nrConsidered))
        else:
            file1.write(str(0))
        file1.close()


if __name__ == "__main__":
    main(sys.argv[1])

