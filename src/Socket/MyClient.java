package Socket;

import java.io.*;
import java.net.*;

public class MyClient {
    public static void main(String args[]) {
        try {
            // Membuat socket dengan alamat IP dan port
            Socket client = new Socket(InetAddress.getLocalHost(), 1234);

            // Mendapatkan input stream dan output stream dari socket
            InputStream clientIn = client.getInputStream();
            OutputStream clientOut = client.getOutputStream();

            // Membuat PrintWriter untuk mengirim pesan ke server
            PrintWriter pw = new PrintWriter(clientOut, true);

            // Membuat BufferedReader untuk menerima pesan dari server
            BufferedReader br = new BufferedReader(new InputStreamReader(clientIn));

            // BufferedReader untuk membaca input dari pengguna
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            // Meminta pengguna untuk memasukkan pesan
            System.out.print("Type a message for the server: ");
            String userInput = stdIn.readLine();

            // Mengirim pesan ke server
            pw.println(userInput);

            // Membaca dan mencetak pesan dari server
            System.out.println("Server message: " + br.readLine());

            // Menutup semua sumber daya
            pw.close();
            br.close();
            client.close();
        } catch (ConnectException ce) {
            System.out.println("Cannot connect to the server.");
        } catch (IOException ie) {
            System.out.println("I/O Error.");
        }
    }
}
