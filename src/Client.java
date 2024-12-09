import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {


    static final String SERVER_IP = "127.0.0.1";
    private static final int PORT = 2545;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // server IP & PORT

        try {
            Socket socket = new Socket(SERVER_IP,PORT);

            // send message

            // read message

            // for reading
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // for writing
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);

            // Thread for reading messages from the server
            new Thread(() -> {
                try {
                    String response;
                    while ((response = reader.readLine()) != null) {
                        System.out.println("Server: " + response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            // Main thread for sending messages to the server

            while (true) {
                System.out.print("Enter a message: ");
                String message = sc.nextLine();
                writer.println(message);
            }





        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // request for connection
        // send message
        // receive



    }
}