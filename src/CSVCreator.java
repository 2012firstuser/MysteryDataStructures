import java.io.FileWriter;

public class CSVCreator {
    public static void exportDatum(int[][][] data, String testname) throws Exception  {
        for (int i = 0; i < data.length; i++) {
            exportData(data[i], testname, i);
        }

    }
    public static void exportData(int[][] data, String testname, int datasetNum) throws Exception {
//        String file = "/MysteryDataStructure" + datasetNum + "/" + testname + ".csv";
        String file = datasetNum + "_" + testname + ".csv";

        FileWriter writer = new FileWriter(file);

        writer.write("n,Best Case,Worst Case\n");
        for(int k = 0; k < data.length; k++){

            String nextline = "";

            for(int j = 0; j <= data[0].length - 2;j++)
            {
                nextline += data[k][j] + ",";
            }

            nextline += data[k][data[0].length - 1];
            nextline += "\n";

            writer.write(nextline);

            System.out.print("Structure: ");
            System.out.print(datasetNum);
            System.out.print(" Test Number: ");
            System.out.print(testname);
            System.out.print(" n: ");
            System.out.print(data[k][0]);
            System.out.print(" best: ");
            System.out.print(data[k][1]);
            System.out.print(" worst: ");
            System.out.println(data[k][2]);
        }
        writer.close();
    }
}

