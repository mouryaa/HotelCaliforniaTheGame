
import javax.swing.JPanel;

public class ClientDriver implements Runnable
{
    ClientVariableStruct variables;
    Client comm;
    Thread t;
    JPanel panel;

    ClientDriver(ClientVariableStruct variables,Client comm,JPanel panel)
    {
       this.variables = variables;
       this.comm = comm;
       this.panel = panel;
       t = new Thread(this);
       t.start();
    }

    @Override
    public void run()
    {
        //System.out.println("Run");
        while(comm.isConnected())
        {
            panel.repaint();
            //System.out.println("running");
            String input = comm.recieve();
            if(input.length()>0)
            {
                //System.out.println("Recieved: "+input);
                int colon = input.indexOf(":");
                String command = input.substring(0, colon).trim();
                int value = Integer.valueOf(input.substring(colon+1).trim());
                System.out.println("Command = "+command+"\tValue = "+value);

                if(command.equals("waiting"))
                {
                    if(value == 1)
                    {
                        variables.waiting = true;
                    }
                    variables.waiting = false;
                }

                if(command.equals("open"))
                {
                    switch(value)
                    {
                        case(-1): variables.doorN1 = true; break;
                        case(-2): variables.doorN2 = true; break;
                        case(-3): variables.doorN3 = true; break;
                        case(-4): variables.doorN4 = true; break;
                    }
                }

                 if(command.equals("close"))
                {
                    switch(value)
                    {
                        case(-1): variables.doorN1 = false; break;
                        case(-2): variables.doorN2 = false; break;
                        case(-3): variables.doorN3 = false; break;
                        case(-4): variables.doorN4 = false; break;
                    }
                }

                if(command.equals("energy"))
                {
                    variables.energy -= 5;
                    comm.send("energy:"+variables.energy);
                    //System.out.println("Energy Recieved");
                    //System.out.println("New Energy Level = "+variables.energy);
                }

                if(command.equals("vx"))
                    variables.vx = value;

                if(command.equals("vy"))
                    variables.vy = value;

                if(command.equals("px"))
                    variables.px = value;

                if(command.equals("py"))
                    variables.py = value;

                if(command.equals("cx"))
                    variables.cx = value;

                if(command.equals("cy"))
                    variables.cy = value;

                if(command.equals("nx"))
                    variables.nx = value;

                if(command.equals("ny"))
                    variables.ny = value;

                if(command.equals("bx"))
                    variables.bx = value;

                if(command.equals("by"))
                    variables.by = value;

                if(command.equals("jx"))
                    variables.jx = value;

                if(command.equals("jy"))
                    variables.jy = value;

                if(command.equals("tx"))
                    variables.tx = value;

                if(command.equals("ty"))
                    variables.ty = value;

                panel.repaint();
            }
        }
        System.out.println("Server Disconnected");
        variables.connected = false;
        comm.disconnect();
    }

    void changeEnergy(int x, int y)
    {
        //V,P,C,N +15 energy
        if(x == variables.vx && y == variables.vy && !variables.usedV)
        {
            variables.energy += 15;
            variables.usedV = true;
        }
        if(x == variables.px && y == variables.py && !variables.usedP)
        {
            variables.energy += 15;
            variables.usedP = true;
        }
        if(x == variables.cx && y == variables.cy && !variables.usedC)
        {
            variables.energy += 15;
            variables.usedC = true;
        }
        if(x == variables.nx && y == variables.ny && !variables.usedN)
        {
            variables.energy += 15;
            variables.usedN = true;
        }
    }

    void changePoints(int x, int y)
    {
        //B,J,T +1 point
        if(x == variables.bx && y == variables.by && !variables.usedB)
        {
            variables.points ++;
            variables.usedB = true;
        }
        if(x == variables.jx && y == variables.jy && !variables.usedJ)
        {
            variables.points ++;
            variables.usedJ = true;
        }
        if(x == variables.tx && y == variables.ty && !variables.usedT)
        {
            variables.points ++;
            variables.usedT = true;
        }
    }
}
