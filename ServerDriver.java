
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ServerDriver implements Runnable
{
    JTextField points,energy,time;
    JPanel panel;
    Server comm;
    int x = 0,y = 0, quadrant = 2,previousQuadrant = 2;
    ServerVariableStruct variables;

    ServerDriver(int i, JPanel Panel, JTextField p1Energy, JTextField p1Points,
                    JTextField p1Time, ServerVariableStruct variables)
    {
        this.panel = Panel;
        energy = p1Energy;
        points = p1Points;
        time = p1Time;
        this.variables = variables;
        comm = new Server(i);
        while(!comm.isConnected())
        {
            try
            {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {}
            comm = new Server(i);
        }

        comm.send("vx:"+variables.vx);
        comm.send("vy:"+variables.vy);
        comm.send("px:"+variables.px);
        comm.send("py:"+variables.py);
        comm.send("cx:"+variables.cx);
        comm.send("cy:"+variables.cy);
        comm.send("nx:"+variables.nx);
        comm.send("ny:"+variables.ny);
        comm.send("bx:"+variables.bx);
        comm.send("by:"+variables.by);
        comm.send("jx:"+variables.jx);
        comm.send("jy:"+variables.jy);
        comm.send("tx:"+variables.tx);
        comm.send("ty:"+variables.ty);


        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run()
    {
		String command;
		int colon,value;
        while(comm.isConnected())
        {
			sendDoors();
            String input = comm.recieve();
            if(input.length()>0)
            {
                try
                {
					colon = input.indexOf(":");
                	command = input.substring(0, colon).trim();
               	 	value = Integer.valueOf(input.substring(colon+1).trim());
                	System.out.println("Command = "+command+"\tValue = "+value);
				}
				catch(Exception e)
				{
					command = "";
					value = 0;
				}

                if(command.equals("points"))
                {
                    points.setText("Points: "+value);
                }
                if(command.equals("unlockOccupied"))
                {
                    unlock(value);
                }
                if(command.equals("time"))
                {
                    time.setText("Time: "+value);
                    if(value > 23)
                    {
                        comm.send("energy:0");
                        System.out.println("Energy Decrease Sent");
                        energy.setText("Energy: "+value);
                    }
                    if(value == 20)
                    {
                        unlock(quadrant);
                    }
                }
                if(command.equals("energy"))
                {
                    energy.setText("Energy: "+value);
                }
                if(command.equals("x"))
                {
                    x = value;
                }
                if(command.equals("y"))
                {
                    y = value;
                }
                if(command.equals("quadrant"))
                {
                    previousQuadrant = quadrant;
                    quadrant = value;
                    if(previousQuadrant != quadrant)
                    {
                        lock(quadrant);
                    }
                }
            }
            panel.repaint();
            comm.send("");
        }
        System.out.println("Client Disconnected");
        comm.disconnect();
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    void send(String string)
    {
        comm.send(string);
    }

    private void lock(int quadrant)
    {

        switch(quadrant)
        {
            case(1):
                variables.quad1 = false;
                variables.doorN1 = false;
                variables.doorN4 = false;
                break;
            case(3):
                variables.quad3 = false;
                variables.doorN2 = false;
                variables.doorN3 = false;
                break;
            case(4):
                variables.quad4 = false;
                variables.doorN3 = false;
                variables.doorN4 = false;
                break;
        }
    }

    private void unlock(int quadrant)
    {
        switch(quadrant)
        {
            case(1):
                variables.quad1 = true;
                variables.doorN1 = true;
                if(variables.quad4)
                {
                    variables.doorN4 = true;
                }
                break;
            case(3):
                variables.quad3 = true;
                variables.doorN2 = true;
                if(variables.quad4)
                {
                    variables.doorN3 = true;
                }
            case(4):
                variables.quad4 = true;
                if(variables.quad1)
                {
                    variables.doorN4 = true;
                }
                if(variables.quad3)
                {
                    variables.doorN3 = true;
                }
        }
    }

    public void sendDoors()
    {
		if(variables.doorN1)
		{
			comm.send("open:-1");
		}
		else
		{
			comm.send("close:-1");
		}
		if(variables.doorN2)
		{
			comm.send("open:-2");
		}
		else
		{
			comm.send("close:-2");
		}
		if(variables.doorN3)
		{
			comm.send("open:-3");
		}
		else
		{
			comm.send("close:-3");
		}
		if(variables.doorN4)
		{
			comm.send("open:-4");
		}
		else
		{
			comm.send("close:-4");
		}
	}
}
