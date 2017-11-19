import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CSVCreator {
    public static void exportData(int[][][] data, String testname) throws Exception
    {
        for (int i = 0; i < data.length; i++) {
            int MysteryDataStructureData[][] = data[i];
            String file = "/MysteryDataStructure" + i + "/" + testname + ".csv";
            FileWriter writer = new FileWriter(file);
            writer.write("n,Best Case,Worst Case,Average Case");
            for(int k = 0; k < MysteryDataStructureData[k].length;k++){
                String nextline = "";
                for(int j = 0; j<3;j++)
                {
                    nextline+= MysteryDataStructureData[k][j] + ",";
                }
                writer.write(nextline);
            }
        }

    }
}

