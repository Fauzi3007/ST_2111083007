package Socket;

import java.io.*;
import java.net.*;

public class Lat3TriviaClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                String serverResponse = reader.readLine();
                System.out.println(serverResponse);
                
                String userMessage = userInput.readLine();
                writer.println(userMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
