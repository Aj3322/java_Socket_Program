import java.io.*;
import java.net.*;

public class Client {
  private  Socket socket=null;
  private DataOutputStream output=null;
  private DataInputStream input=null;

  public Client(String host, int port) throws IOException{
     try {
      Socket socket=new Socket(host, port);
      System.out.println("Connected");

      input = new DataInputStream(System.in);

      output = new DataOutputStream(socket.getOutputStream());


     } catch (UnknownHostException e) {
      e.printStackTrace();
     } catch (IOException e) {
      e.printStackTrace();
     }

     String line = "";

     while ((line = input.readLine()) != null){
        output.writeUTF(line);
     }

     try {
      socket.close();
      input.close();
      output.close();
     } catch (IOException e) {
      e.printStackTrace();
     }
  }

  public static void main(String[] args) throws IOException {
    Client client = new Client("127.0.0.1",5000);
  }
}
