package Controllers;

import Data_models.MigrationThread;
import Views.ChartView;
import Views.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Controller implements ActionListener {
    private View view;
    private ChartView chartView;

    public Controller(View view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command == "STATIC ALLOCATION") {
            try {
                Process processC = Runtime.getRuntime().exec(".//Testc.exe staticAllocation");
                processC.waitFor();
                Process processJ = Runtime.getRuntime().exec("java Testj staticAllocation");
                processJ.waitFor();

                File myFile = new File(".//Results//staticAllocation.txt");
                FileReader fileReader = new FileReader(myFile);
                BufferedReader reader = new BufferedReader(fileReader);
                reader.readLine();
                double dataC[] = new double[100];

                for (int i = 0; i < 100; i++) {
                    dataC[i] = Double.parseDouble(reader.readLine());
                }

                reader.readLine();
                double averageC = Double.parseDouble(reader.readLine());

                reader.readLine();
                reader.readLine();

                double dataJ[] = new double[100];

                for (int i = 0; i < 100; i++) {
                    dataJ[i] = Double.parseDouble(reader.readLine());
                }

                reader.readLine();
                double averageJ = Double.parseDouble(reader.readLine());

                fileReader.close();
                reader.close();
                chartView = new ChartView("Static Allocation", dataC, averageC, dataJ, averageJ);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (command == "DYNAMIC ALLOCATION") {
            try {
                Process processC = Runtime.getRuntime().exec("Testc.exe dynamicAllocation");
                processC.waitFor();
                Process processJ = Runtime.getRuntime().exec("java Testj dynamicAllocation");
                processJ.waitFor();
                Process processP = Runtime.getRuntime().exec("python Testp.py dynamicAllocation");
                processP.waitFor();

                File myFile = new File(".//Results//dynamicAllocation.txt");
                FileReader fileReader = new FileReader(myFile);
                BufferedReader reader = new BufferedReader(fileReader);
                reader.readLine();
                double dataC[] = new double[100];

                for (int i = 0; i < 100; i++) {
                    dataC[i] = Double.parseDouble(reader.readLine());
                }

                reader.readLine();
                double averageC = Double.parseDouble(reader.readLine());

                reader.readLine();
                reader.readLine();

                double dataJ[] = new double[100];

                for (int i = 0; i < 100; i++) {
                    dataJ[i] = Double.parseDouble(reader.readLine());
                }

                reader.readLine();
                double averageJ = Double.parseDouble(reader.readLine());

                reader.readLine();
                reader.readLine();

                double dataP[] = new double[100];

                for (int i = 0; i < 100; i++) {
                    dataP[i] = Double.parseDouble(reader.readLine());
                }

                reader.readLine();
                double averageP = Double.parseDouble(reader.readLine());

                fileReader.close();
                reader.close();
                chartView = new ChartView("Dynamic Allocation", dataC, averageC, dataJ, averageJ, dataP, averageP);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (command == "STATIC ACCESS") {
            try {
                Process processC = Runtime.getRuntime().exec("Testc.exe staticAccess");
                processC.waitFor();
                Process processJ = Runtime.getRuntime().exec("java Testj staticAccess");
                processJ.waitFor();

                File myFile = new File(".//Results//staticAccess.txt");
                FileReader fileReader = new FileReader(myFile);
                BufferedReader reader = new BufferedReader(fileReader);
                reader.readLine();
                double dataC[] = new double[100];

                for (int i = 0; i < 100; i++) {
                    dataC[i] = Double.parseDouble(reader.readLine());
                }

                reader.readLine();
                double averageC = Double.parseDouble(reader.readLine());

                reader.readLine();
                reader.readLine();

                double dataJ[] = new double[100];

                for (int i = 0; i < 100; i++) {
                    dataJ[i] = Double.parseDouble(reader.readLine());
                }

                reader.readLine();
                double averageJ = Double.parseDouble(reader.readLine());

                fileReader.close();
                reader.close();
                chartView = new ChartView("Static Access", dataC, averageC, dataJ, averageJ);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (command == "DYNAMIC ACCESS") {
            try {
                Process processC = Runtime.getRuntime().exec("Testc.exe dynamicAccess");
                processC.waitFor();
                Process processJ = Runtime.getRuntime().exec("java Testj dynamicAccess");
                processJ.waitFor();
                Process processP = Runtime.getRuntime().exec("python Testp.py dynamicAccess");
                processP.waitFor();

                File myFile = new File(".//Results//dynamicAccess.txt");
                FileReader fileReader = new FileReader(myFile);
                BufferedReader reader = new BufferedReader(fileReader);
                reader.readLine();
                double dataC[] = new double[100];

                for (int i = 0; i < 100; i++) {
                    dataC[i] = Double.parseDouble(reader.readLine());
                }

                reader.readLine();
                double averageC = Double.parseDouble(reader.readLine());

                reader.readLine();
                reader.readLine();

                double dataJ[] = new double[100];

                for (int i = 0; i < 100; i++) {
                    dataJ[i] = Double.parseDouble(reader.readLine());
                }

                reader.readLine();
                double averageJ = Double.parseDouble(reader.readLine());

                reader.readLine();
                reader.readLine();

                double dataP[] = new double[100];

                for (int i = 0; i < 100; i++) {
                    dataP[i] = Double.parseDouble(reader.readLine());
                }

                reader.readLine();
                double averageP = Double.parseDouble(reader.readLine());

                fileReader.close();
                reader.close();
                chartView = new ChartView("Dynamic Access", dataC, averageC, dataJ, averageJ, dataP, averageP);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (command == "THREAD CREATION") {
            try {
                Process processC = Runtime.getRuntime().exec("Testc.exe createThread");
                processC.waitFor();
                Process processJ = Runtime.getRuntime().exec("java Testj createThread");
                processJ.waitFor();
                Process processP = Runtime.getRuntime().exec("python Testp.py createThread");
                processP.waitFor();

                File myFile = new File(".//Results//threadCreation.txt");
                FileReader fileReader = new FileReader(myFile);
                BufferedReader reader = new BufferedReader(fileReader);
                reader.readLine();
                double dataC[] = new double[100];

                for (int i = 0; i < 100; i++) {
                    dataC[i] = Double.parseDouble(reader.readLine());
                }

                reader.readLine();
                double averageC = Double.parseDouble(reader.readLine());

                reader.readLine();
                reader.readLine();

                double dataJ[] = new double[100];

                for (int i = 0; i < 100; i++) {
                    dataJ[i] = Double.parseDouble(reader.readLine());
                }

                reader.readLine();
                double averageJ = Double.parseDouble(reader.readLine());

                reader.readLine();
                reader.readLine();

                double dataP[] = new double[100];

                for (int i = 0; i < 100; i++) {
                    dataP[i] = Double.parseDouble(reader.readLine());
                }

                reader.readLine();
                double averageP = Double.parseDouble(reader.readLine());

                fileReader.close();
                reader.close();
                chartView = new ChartView("Thread Creation", dataC, averageC, dataJ, averageJ, dataP, averageP);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (command == "THREAD SWITCH") {
            try {
                Process processC = Runtime.getRuntime().exec("Testc.exe contextSwitch");
                processC.waitFor();
                Process processJ = Runtime.getRuntime().exec("java Testj contextSwitch");
                processJ.waitFor();
                Process processP = Runtime.getRuntime().exec("python Testp.py contextSwitch");
                processP.waitFor();

                File myFile = new File(".//Results//threadContextSwitch.txt");
                FileReader fileReader = new FileReader(myFile);
                BufferedReader reader = new BufferedReader(fileReader);
                reader.readLine();
                double dataC[] = new double[100];

                for (int i = 0; i < 100; i++) {
                    dataC[i] = Double.parseDouble(reader.readLine());
                }

                reader.readLine();
                double averageC = Double.parseDouble(reader.readLine());

                reader.readLine();
                reader.readLine();

                double dataJ[] = new double[100];

                for (int i = 0; i < 100; i++) {
                    dataJ[i] = Double.parseDouble(reader.readLine());
                }

                reader.readLine();
                double averageJ = Double.parseDouble(reader.readLine());

                reader.readLine();
                reader.readLine();

                double dataP[] = new double[100];

                for (int i = 0; i < 100; i++) {
                    dataP[i] = Double.parseDouble(reader.readLine());
                }

                reader.readLine();
                double averageP = Double.parseDouble(reader.readLine());

                fileReader.close();
                reader.close();
                chartView = new ChartView("Thread Context Switch", dataC, averageC, dataJ, averageJ, dataP, averageP);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (command == "THREAD MIGRATION") {
            try {
                Process processC = Runtime.getRuntime().exec("Testc.exe threadMigration");
                processC.waitFor();

                double dataOut[] = new double[100];
                for (int i = 0; i < 100; i++) {
                    dataOut[i] = threadMigration();
                }

                int nrConsidered = 0;
                double average = 0;
                for (int i = 0; i < 100; i++) {
                    if (dataOut[i] <= 12500) {
                        average += dataOut[i];
                        nrConsidered++;
                    }
                }
                File myFile = new File(".//Results//threadMigration.txt");
                FileReader fileReader = new FileReader(myFile);
                BufferedReader reader = new BufferedReader(fileReader);
                FileWriter writer = new FileWriter(".//Results//threadMigration.txt", true);

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
                Process processP = Runtime.getRuntime().exec("python Testp.py threadMigration");
                processP.waitFor();

                myFile = new File(".//Results//threadMigration.txt");
                fileReader = new FileReader(myFile);
                reader = new BufferedReader(fileReader);
                reader.readLine();
                double dataC[] = new double[100];

                for (int i = 0; i < 100; i++) {
                    dataC[i] = Double.parseDouble(reader.readLine());
                }

                reader.readLine();
                double averageC = Double.parseDouble(reader.readLine());

                reader.readLine();
                reader.readLine();

                double dataJ[] = new double[100];

                for (int i = 0; i < 100; i++) {
                    dataJ[i] = Double.parseDouble(reader.readLine());
                }

                reader.readLine();
                double averageJ = Double.parseDouble(reader.readLine());

                reader.readLine();
                reader.readLine();

                double dataP[] = new double[100];

                for (int i = 0; i < 100; i++) {
                    dataP[i] = Double.parseDouble(reader.readLine());
                }

                reader.readLine();
                double averageP = Double.parseDouble(reader.readLine());

                fileReader.close();
                reader.close();
                chartView = new ChartView("Thread Migration", dataC, averageC, dataJ, averageJ, dataP, averageP);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    static double threadMigration() {
        MigrationThread myThread = new MigrationThread();
        myThread.run();

        return myThread.getDurationMigration();
    }
}
