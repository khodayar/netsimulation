import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Main {

    public static void main(final String[] args) {
        int dpnc[][]=Reader.readDpdnc("dependency.txt");
        Random rand = new Random();
        PrintWriter pr;
        
        
        try {
            pr = new PrintWriter("C:\\Users\\jeiroodi\\Documents\\alarm.txt");
            pr.println("pec1 pec2 pec3 pec4 pec5 pec6 pec7 pec8 pec9 pec10");
        
        for (int iterate=1 ; iterate<1000; iterate++) {
            String[] pec=new String[10];
            
            int alarm=(int)(Math.random() * 10);

            for (int i=0;i<10;i++) {

                if (Math.random() <= dpnc[alarm][i]/100)
                    pec[i]="yes";
                else
                    pec[i]="no";

            }
            for (int i=0;i<10;i++) {
               pr.print(pec[i]+" ");               
            }
            pr.println();
        }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        
    }
}

