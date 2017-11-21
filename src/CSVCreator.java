import java.io.FileWriter;

public class CSVCreator {
    public static void exportDatum(int[][][] data, String testname) throws Exception
    {
        for (int i = 0; i < data.length; i++) {
            exportData(data[i], testname, i);
        }

    }
    public static void exportData(int[][] data, String testname, int datasetNum) throws Exception
    {
        String file = "/MysteryDataStructure" + datasetNum + "/" + testname + ".csv";
        FileWriter writer = new FileWriter(file);
        writer.write("n,Best Case,Worst Case,Average Case");
        for(int k = 0; k < data[k].length;k++){
            String nextline = "";
            for(int j = 0; j<3;j++)
            {
                nextline+= data[k][j] + ",";
            }
            writer.write(nextline);
        }
    }
}

