package Thread;
import javax.swing.*;
import java.awt.*;

public class Lat1Banner extends JFrame {
    private JLabel output;
    private String input;

    public Lat1Banner() {
        setTitle("Latihan 1 Banner");
        setSize(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        input = "Fauzi Isyrin Apridal";
        output = new JLabel(input);
        output.setFont(new Font("Times New Roman", Font.BOLD, 32));
        add(output, BorderLayout.CENTER);

        setVisible(true);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500); 
                        input = input.substring(1) + input.charAt(0);
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                output.setText(input);
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }


    public static void main(String[] args) {
        new Lat1Banner();
    }
}