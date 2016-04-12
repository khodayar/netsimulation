import java.util.Observable;

public class NodeThread extends Observable implements Runnable  {

    private Thread t;
    private String nodename;
    private boolean fault;

    public NodeThread(String threadname){
        nodename = threadname;
        System.out.println("Creating thread :" +  nodename );

    }

    public void run() {

        System.out.println("Node "+nodename+" is running");
        try {
            for (int i=0;i<1000;i++) {
                int alarm=(int)(Math.random() * 100);
                if (alarm>95) {
                    fault=true;
                    this.setChanged();
                    this.notifyObservers();
                }
                fault=false;
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " +  nodename + " interrupted.");
            //e.printStackTrace();
        }
        System.out.println("Thread " +  nodename + " exiting.");
    }


    public void start ()
    {
        System.out.println("Starting " +  nodename );
        if (t == null)
        {
            t = new Thread (this, nodename);
            t.start ();
        }
    }

    public String getNodename() {
        return nodename;
    }

    public boolean isFault() {
        return fault;
    }

}
