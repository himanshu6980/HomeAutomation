import java.io.*;
import java.net.*;

 class Client
 {
    Socket s;
    BufferedReader r;
    PrintWriter w;
    BufferedReader con;
    int GPIO_NO;
    String ip;
    int port;
     Client(String ip, int port,int GPIO_NO)
    {
        this.ip = ip;
        this.port = port;
       this.GPIO_NO= GPIO_NO;
    }
     void connect()
     {      try{
          s = new Socket(ip,port);
            }catch(Exception e)
                {
                    System.err.println(e);
                }
        Reciever();
        
     }
        void Reciever()
        {   
            try{
             r = new BufferedReader(new InputStreamReader(s.getInputStream()));
			 w = new PrintWriter(s.getOutputStream(), true);
            // con = new BufferedReader(new InputStreamReader(System.in));
            }catch(Exception e )
            {
                System.err.println(e);
            }
            getMsg();
        }

        void getMsg()
        {
            try {
        
				//line = con.readLine();
				w.println(GPIO_NO);
                
			
            } catch (Exception e) {
                
                System.err.println(e);
            }
        }

	public static void main(String[] args)
	{
		try
		{
           
            Client c = new Client(args[0],Integer.parseInt(args[1]),Integer.parseInt(args[2]));
            c.connect();
		
		
		}
		catch (Exception err)
		{
			System.err.println(err);
		}
	}
}

