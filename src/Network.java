
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Observable;
import java.util.Observer;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Network implements Observer{

    int arlamMatrix[][]=Reader.readDpdnc("dependency.txt");
    PrintWriter pr;
   
    String log;

    @Override
    public void update(Observable ob, Object object) {
       // boolean failure=((NodeThread) ob).isFault();
        writeAlarm((NodeThread) ob);
    }


    public synchronized void writeAlarm(NodeThread node){
        try {
            pr = new PrintWriter(new FileOutputStream(new File ("C:\\Users\\kjeirroo\\Documents\\alarm.txt"),true));

            for (int i =0;i<8;i++) {
                if (arlamMatrix[Integer.parseInt(node.getNodename())-1][i]==1){
                	//----- in case if I wanted to use timestamps ------- 
                	//Calendar cal = Calendar.getInstance();
                    //SimpleDateFormat moment = new SimpleDateFormat("HH:mm:ss");
                	// (int)(Math.random()*3)-1)
                     pr.println("M"+(i+1)+" "+  (System.currentTimeMillis()+(int)(Math.random()*3)-1));
                }
            }

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
        pr.close();
    }

}
