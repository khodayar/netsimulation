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

    	//array for giving each node different failure rate/probability
    	int [] prbl={95,94,93,98,96,94,98,96};
    	
        System.out.println("Node "+nodename+" started");
        try {
            for (int i=0;i<250;i++) {
                int alarm=(int)(Math.random() * 100);
                if (alarm> prbl[Character.getNumericValue(nodename.charAt(0))-1]) {
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
