import java.io.*;
import java.net.*;

public class Server
{
    private ServerSocket server = null;
    Thread t;
    private DataInputStream is;
    private DataOutputStream os;
    private boolean connected = false;
    private BufferedReader inputBuff;

    public Server(int port)
    {
        init(port);
    }


    private void init(int port)
    {
        connected = false;
	try
	{
            server = new ServerSocket(port);
            Socket client = server.accept();
            System.out.println("Connected");
            InetAddress cip = client.getInetAddress();
            System.out.println( "Client IP Addr: "+cip.toString());

            is = new DataInputStream( client.getInputStream() );
            //is is used for receiving stream from the client
            os = new DataOutputStream( client.getOutputStream() );
            //os is used for sending stream to the client
            inputBuff = new BufferedReader(new InputStreamReader(is));

            connected = true;
	}
	catch( IOException e )
        {
            System.out.println( "Could not get I/O for the connection to port "+port);
	}
		//System.out.println( "Server Down" );
     }
    
    public void disconnect()
    {
        try 
        {
            is.close();
            os.close();
            server.close();
        } catch (IOException ex) {}
    }


    public boolean isConnected()
    {
        return connected;
    }

    public String recieve()
    {
        try
        {
            String input = inputBuff.readLine();
            if(input!=null)
            {  
                return input;
            }
	}
	catch(Exception e)
	{
            //System.out.println(e.getMessage());
            connected = false;
            System.out.println("\nERROR: Connection to Server LOST\n");
        }
        return "";
    }

     public void send(String input)
     {
         try
         {
             os.flush();
             os.writeBytes(input+"\n");
             //System.out.println("Sending: "+input);
        }
        catch(Exception e)
        {
            connected = false;
            //System.out.println(e.getMessage());
            System.out.println("\nERROR: Connection LOST\n");
        }
    }
 }

