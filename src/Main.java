/**
 * Network fault propagation simulator
 * Author : Khodayar Jeirroodi
 *  
 */
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {

    public static void main(final String[] args) {
        try {
            PrintWriter pr=  pr = new PrintWriter("C:\\Users\\jeiroodi\\Documents\\alarm.txt");
            pr.println("port time source");
            pr.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        NodeThread[] nodes=new  NodeThread[8];
        Network network=new Network();

        for (int i=0;i<8;i++){
            nodes[i] =new NodeThread(Integer.toString(i+1));
            nodes[i].addObserver(network);
            nodes[i].start();
        }
    }
}

