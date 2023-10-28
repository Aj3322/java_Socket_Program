import java.io.*;
import java.net.*;

public class Server {
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream input = null;

    public Server(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server initialized");

            System.out.println("Waiting for a client...");
            socket = server.accept();
            System.out.println("Client Accepted");

            input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            String line = "";

            while (!line.equals("Over")) {
                try {
                    line = input.readUTF();
                    System.out.println("Received: " + line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Closing Connection");
            input.close();
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException{
        Server server = new Server(5000);
    }
}
