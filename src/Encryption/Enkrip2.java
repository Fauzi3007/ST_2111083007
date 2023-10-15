/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Encryption;

/**
 *
 * @author Fauzi
 */
public class Enkrip2 {
    public static void main(String[] args) {
        String text = "\\jcnbn{/Kn{nah";
        String temp = "";
        int key = 15;
        for (int i = 0; i < text.length(); i++) {
            int h = (int) (text.charAt(i));
            char t = (char) (h^key);
            temp += t;
        }
        
        System.out.println("Sebelum enkrip : "+text);
        System.out.println("Sesudah enkrip : "+temp);
        
    }
}
