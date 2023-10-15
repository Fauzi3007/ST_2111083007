
package Socket;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lat3TriviaClientHandler extends Thread {
    private Socket clientSocket;
    private BufferedReader reader;
    private PrintWriter writer;
    private boolean waitingForAnswer = false;
     private List<String> questions = new ArrayList<>();
    private List<String> answers = new ArrayList();
    

    public Lat3TriviaClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        questions.add("Siapa pembuat Java?");
        answers.add("James Gosling");
        questions.add("Siapa nama dosen ST?");
        answers.add("Ervan");
        questions.add("Kapan Indonesia Merdeka?");
        answers.add("17 Agustus 1945");
        questions.add("Siapa Pemilik Steam?");
        answers.add("Gabe Newell");
        questions.add("Siapa pembuat Google?");
        answers.add("Larry Page");
    
        try {
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            writer = new PrintWriter(clientSocket.getOutputStream(), true);

            writer.println("Selamat datang di kuis! Ketik 'permintaan' untuk pertanyaan atau 'jawaban' untuk menjawab.");
            
            while (true) {
                String clientMessage = reader.readLine();
                if (clientMessage.equals("permintaan")) {
                    String question = getRandomQuestion();
                    int index = questions.indexOf(question)+1;
                    writer.println(  index+ "#" + question);
                    waitingForAnswer = true;
                } else if (clientMessage.equals("jawaban") && waitingForAnswer) {
                    writer.println("Berikan jawabanmu dengan format: <nomor pertanyaan>#<jawaban anda>");
                } else if (waitingForAnswer) {
                    String[] parts = clientMessage.split("#");
                    if (parts.length == 2) {
                        int questionNumber = Integer.parseInt(parts[0]);
                        String userAnswer = parts[1].trim();
                        String correctAnswer = getAnswer(questionNumber);
                        
                        if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                            writer.println("Jawaban benar!");
                        } else {
                            writer.println("Jawaban salah. Jawaban yang benar: " + correctAnswer);
                        }
                        
                        waitingForAnswer = false;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getRandomQuestion() {
    // Mengambil pertanyaan secara acak dari daftar pertanyaan
    int index = new Random().nextInt(questions.size());
    return questions.get(index);
}

private String getAnswer(int questionNumber) {
    // Mengambil jawaban berdasarkan nomor pertanyaan
    if (questionNumber > 0 && questionNumber <= answers.size()) {
        return answers.get(questionNumber - 1);
    } else {
        return "Pertanyaan tidak ditemukan";
    }
}


}
