import java.net.*;
import java.io.*;

public class Server2 {
    public static void main(String[] args) {
        try{
        ServerSocket ss = new ServerSocket(3000);
        System.out.println("Server is running");

        Socket s = ss.accept();
        System.out.println("Client Accepted");
         
        PrintStream ps = new PrintStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

        while(true){
        String str,str1;
        while(!(str = br.readLine()).equals("exit")){
            System.out.println("Message from Aj: "+str);
            str1=br2.readLine();

            ps.println(str1);
            }

            ps.close();
            br.close();
            br2.close();
            s.close();
            ss.close();

            System.exit(0);

        }

        }
        catch (IOException e){
            e.printStackTrace();
            }
    }
}
