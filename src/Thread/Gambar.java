
package Thread;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Gambar {
    public static void main(String[] args) {
        String filePath = "F:\\gambar.jpeg"; 

        try {
            String newText = "Hello World";
            
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(newText);
            bufferedWriter.newLine(); 
            bufferedWriter.close();

            System.out.println("Teks berhasil ditambahkan ke file gambar.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
