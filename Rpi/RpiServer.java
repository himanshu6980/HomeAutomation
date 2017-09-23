import java.io.*;
import java.net.*;
public class Server{
        public static void main(String[] args){
                String str;
                try{
                        ServerSocket ss = new ServerSocket(3001);
                        Socket s = ss.accept();
                        System.out.println("Connection accepted");
                        DataInputStream dis = new DataInputStream(s.getInputStream());
                        str = (String) dis.readUTF();
                        //call script in place of printing
                        System.out.println("message = "+str);
                        ss.close();
                }catch(Exception e){
                        e.printStackTrace();
                }
        }
}
