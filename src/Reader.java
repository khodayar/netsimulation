

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Reader {

    static int[][] readDpdnc(String filename) {

        int linenumber = 0; // line number starts from the second line
        int rows = 0;
        int columns = 0; 


        int[][] dpnc=new int[1][1];
        String[] tokens;

        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
            String line = null;

            // read the 1st line, dimensions of the map
            line = br.readLine();
            tokens = line.split("\\s+");
            rows = Integer.parseInt(tokens[0]);
            columns = Integer.parseInt(tokens[1]);

            dpnc = new int[rows][columns];

            // read grids
            while ((line = br.readLine()) != null)  {

                // \\s+ means any number of white spaces between tokens
                tokens = line.split("\\s+");

                for (int i = 0; i < columns; i++) {
                    dpnc[linenumber][i] =Integer.parseInt(tokens[i]);
                }

                linenumber = linenumber + 1; // next line (lane) information

            } // end of read grids



            br.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return dpnc;
    }
    
}

