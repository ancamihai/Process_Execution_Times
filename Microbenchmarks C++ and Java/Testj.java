import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Testj {
    public static void main(String[] args) {
        try {

            if (args[0].equals("staticAllocation")) {
                double dataOut[] = new double[100];
                for (int i = 0; i < 100; i++) {
                    dataOut[i] = staticAllocation() / 1000;
                }
                int nrConsidered = 0;
                double average = 0;
                for (int i = 0; i < 100; i++) {
                    if (dataOut[i] < 8.1) {
                        average += dataOut[i];
                        nrConsidered++;
                    }
                }
                File myFile = new File(".//Results//staticAllocation.txt");
                FileReader fileReader = new FileReader(myFile);
                BufferedReader reader = new BufferedReader(fileReader);
                FileWriter writer = new FileWriter(".//Results//staticAllocation.txt", true);

                writer.write("Java\n");

                for (int i = 0; i < 100; i++) {
                    writer.write(dataOut[i] + "\n");
                }

                writer.write("Average:\n");
                if (nrConsidered == 0) {
                    writer.write(0 + "\n\n");
                } else {
                    average = average / nrConsidered;
                    writer.write(average + "\n\n");
                }

                fileReader.close();
                reader.close();
                writer.close();
            } else if (args[0].equals("staticAccess")) {
                double dataOut[] = new double[100];
                for (int i = 0; i < 100; i++) {
                    dataOut[i] = staticAccess() / 1000;
                }
                int nrConsidered = 0;
                double average = 0;
                for (int i = 0; i < 100; i++) {
                    if (dataOut[i] < 8) {
                        average += dataOut[i];
                        nrConsidered++;
                    }
                }
                File myFile = new File(".//Results//staticAccess.txt");
                FileReader fileReader = new FileReader(myFile);
                BufferedReader reader = new BufferedReader(fileReader);
                FileWriter writer = new FileWriter(".//Results//staticAccess.txt", true);

                writer.write("Java\n");

                for (int i = 0; i < 100; i++) {
                    writer.write(dataOut[i] + "\n");
                }

                writer.write("Average:\n");
                if (nrConsidered == 0) {
                    writer.write(0 + "\n\n");
                } else {
                    average = average / nrConsidered;
                    writer.write(average + "\n\n");
                }

                fileReader.close();
                reader.close();
                writer.close();
            } else if (args[0].equals("dynamicAllocation")) {
                double dataOut[] = new double[100];
                for (int i = 0; i < 100; i++) {
                    dataOut[i] = dynamicAllocation() / 1000;
                }
                int nrConsidered = 0;
                double average = 0;
                for (int i = 0; i < 100; i++) {
                    if (dataOut[i] < 50) {
                        average += dataOut[i];
                        nrConsidered++;
                    }
                }
                File myFile = new File(".//Results//dynamicAllocation.txt");
                FileReader fileReader = new FileReader(myFile);
                BufferedReader reader = new BufferedReader(fileReader);
                FileWriter writer = new FileWriter(".//Results//dynamicAllocation.txt", true);

                writer.write("Java\n");

                for (int i = 0; i < 100; i++) {
                    writer.write(dataOut[i] + "\n");
                }

                writer.write("Average:\n");
                if (nrConsidered == 0) {
                    writer.write(0 + "\n\n");
                } else {
                    average = average / nrConsidered;
                    writer.write(average + "\n\n");
                }

                fileReader.close();
                reader.close();
                writer.close();
            } else if (args[0].equals("dynamicAccess")) {
                double dataOut[] = new double[100];
                for (int i = 0; i < 100; i++) {
                    dataOut[i] = dynamicAccess() / 1000;
                }
                int nrConsidered = 0;
                double average = 0;
                for (int i = 0; i < 100; i++) {
                    if (dataOut[i] < 10) {
                        average += dataOut[i];
                        nrConsidered++;
                    }
                }
                File myFile = new File(".//Results//dynamicAccess.txt");
                FileReader fileReader = new FileReader(myFile);
                BufferedReader reader = new BufferedReader(fileReader);
                FileWriter writer = new FileWriter(".//Results//dynamicAccess.txt", true);

                writer.write("Java\n");

                for (int i = 0; i < 100; i++) {
                    writer.write(dataOut[i] + "\n");
                }

                writer.write("Average:\n");
                if (nrConsidered == 0) {
                    writer.write(0 + "\n\n");
                } else {
                    average = average / nrConsidered;
                    writer.write(average + "\n\n");
                }

                fileReader.close();
                reader.close();
                writer.close();
            } else if (args[0].equals("createThread")) {
                double dataOut[] = new double[100];
                for (int i = 0; i < 100; i++) {
                    dataOut[i] = threadCreation() / 5;
                }

                int nrConsidered = 0;
                double average = 0;
                for (int i = 0; i < 100; i++) {
                    if (dataOut[i] < 4000) {
                        average += dataOut[i];
                        nrConsidered++;
                    }
                }
                File myFile = new File(".//Results//threadCreation.txt");
                FileReader fileReader = new FileReader(myFile);
                BufferedReader reader = new BufferedReader(fileReader);
                FileWriter writer = new FileWriter(".//Results//threadCreation.txt", true);

                writer.write("Java\n");

                for (int i = 0; i < 100; i++) {
                    writer.write(dataOut[i] + "\n");
                }
                writer.write("Average:\n");
                if (nrConsidered == 0) {
                    writer.write(0 + "\n\n");
                } else {
                    average = average / nrConsidered;
                    writer.write(average + "\n\n");
                }

                fileReader.close();
                reader.close();
                writer.close();
            } else if (args[0].equals("contextSwitch")) {
                double dataOut[] = new double[100];
                for (int i = 0; i < 100; i++) {
                    dataOut[i] = threadContextSwitch();
                }

                int nrConsidered = 0;
                double average = 0;
                for (int i = 0; i < 100; i++) {
                    if (dataOut[i] <= 70000) {
                        average += dataOut[i];
                        nrConsidered++;
                    }
                }
                File myFile = new File(".//Results//threadContextSwitch.txt");
                FileReader fileReader = new FileReader(myFile);
                BufferedReader reader = new BufferedReader(fileReader);
                FileWriter writer = new FileWriter(".//Results//threadContextSwitch.txt", true);

                writer.write("Java\n");

                for (int i = 0; i < 100; i++) {
                    writer.write(dataOut[i] + "\n");
                }
                writer.write("Average:\n");
                if (nrConsidered == 0) {
                    writer.write(0 + "\n\n");
                } else {
                    average = average / nrConsidered;
                    writer.write(average + "\n\n");
                }

                fileReader.close();
                reader.close();
                writer.close();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static double staticAllocation() {
        long startTime = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            int x = 5;
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        return Long.valueOf(duration).doubleValue();
    }

    static double staticAccess() {

        int x = 5;
        int y = 6;

        long startTime = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            y = x;
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        return Long.valueOf(duration).doubleValue();
    }

    static double dynamicAllocation() {
        long startTime = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            int array[] = new int[5];
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        return Long.valueOf(duration).doubleValue();
    }


    static double dynamicAccess() {
        int array[] = new int[5];
        array[0] = 5;
        int x = 6;

        long startTime = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            x = array[0];
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        return Long.valueOf(duration).doubleValue();
    }

    static double threadCreation() {
        long startTime = System.nanoTime();

        for (int i = 0; i < 5; i++) {
            MyThread t = new MyThread();
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        return Long.valueOf(duration).doubleValue();
    }

    static double threadContextSwitch() {
        long duration = 0;

        SynchronizedThread threads[] = new SynchronizedThread[25];

        for (int i = 0; i < 25; i++) {
            threads[i] = new SynchronizedThread();
        }

        long startTime = System.nanoTime();

        for (int i = 0; i < 25; i++) {
            threads[i].start();
        }

        try {
            for (int i = 0; i < 25; i++) {
                threads[i].join();
            }
        } catch (Exception e)
        {

        }

        long endTime = System.nanoTime();

        duration = endTime - startTime ;

        return Long.valueOf(duration).doubleValue() / 25;
    }

}