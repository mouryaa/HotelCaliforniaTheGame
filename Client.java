/*
 * Client class to handle all communication for the GUI
 */

 import java.io.*;
 import java.net.*;

 public class Client
 {
    Socket mySocket;

    DataOutputStream os;
    DataInputStream is;
    BufferedReader inputBuff;
    boolean connected = false;

     public Client(String server,int port)
     {
	init(server,port);
     }

     private void init(String server,int port)
      {
         try
         {
            connected = false;
            mySocket = new Socket( server, port );
            System.out.println("Server: " + server+"\nPort: "+port);
         //  connect to the server at the given port

            os = new DataOutputStream( mySocket.getOutputStream() );
         //os is used for sending packets to server
            is = new DataInputStream( mySocket.getInputStream() );
         //is is used for receiving packets from server
            inputBuff = new BufferedReader(new InputStreamReader(is));
            connected = true;
         }
         catch( IOException e )
         {
             System.err.println( "Could not get I/O for the connection to " + server);
         }
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
                System.out.println("\nERROR: Connection to Server LOST\n");
            }
         }

         public String recieve()
         {
            try
            {
		if(inputBuff.ready())
		return inputBuff.readLine();
            }catch(Exception e){}
            return "";
	}


    public boolean isConnected()//returns true if connected to a server
    {
        return connected;
    }
    
    public void disconnect()
    {
        try 
        {
            is.close();
            os.close();
            mySocket.close();
        } catch (IOException ex) {}
    }
}
