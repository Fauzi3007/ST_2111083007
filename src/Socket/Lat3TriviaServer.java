package Socket;

import java.io.*;
import java.net.*;


public class Lat3TriviaServer {
   
    private ServerSocket serverSocket;

    public Lat3TriviaServer(int port) {
        // Tambahkan pertanyaan dan jawaban
       
        // Tambahkan pertanyaan lain sesuai kebutuhan
        
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        System.out.println("Server berjalan...");
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                new Lat3TriviaClientHandler(clientSocket).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Lat3TriviaServer server = new Lat3TriviaServer(1234);
        server.start();
    }
}
