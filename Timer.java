import javax.swing.JPanel;
import javax.swing.JTextField;

public class Timer implements Runnable
{
    private JPanel panel;
    private Thread t;
    private int time = 0;
    private JTextField textField;
    private boolean counting = true;
    private Client comm;


    Timer(JPanel panel,JTextField textField,Client comm)
    {
        this.panel = panel;
        this.textField = textField;
        this.comm = comm;
        t  = new Thread(this);
    }
    
    void startCount()
    {
        System.out.println("Count Started");
        time = 0;
        t.start();
    }
    
    void stopCount()
    {
        counting = false;
        System.out.println("stopCount called");
    }
    
    int currentTime()
    {
        return time;
    }
    
    @Override
    public void run() 
    {
        while(counting)
        {
            //System.out.println("Time = "+time);
            textField.setText("Time: "+time);
            try 
            {
                Thread.sleep(1000);
            } catch (Exception e) { }
            time++;
            comm.send("");
            comm.send("time:"+time);
            panel.repaint();
        }
        System.out.println("Timer Thread Exited");

    }
}
