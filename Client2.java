import java.net.*;
import java.io.*;

public class Client2 {
    public static void main(String[] args) {
        try{
        Socket s = new Socket("127.0.0.1" ,3000);

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

        String str , str1;

        while(!(str=br2.readLine()).equals("exit")){
             
            dos.writeUTF(str+"\n");

            str1=br.readLine();
            System.out.println("Message from Client: " + str1);
        }

        dos.close();
        br.close();
        br2.close();
        s.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
