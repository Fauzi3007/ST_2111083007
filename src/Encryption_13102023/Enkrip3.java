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
public class Enkrip3 {
    public static void main(String[] args) {
        char[] kr = {'0','1','3','4','5','6','7','8','9',' ','.',
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n'
            ,'o','p','q','r','s','t','u','v','w','x','y','z'};
        
        String temp = "";
        String text = "selamat datang";
        int geser = 1;
        char[] cArray = (text.toCharArray());
        for (char c : cArray) {
            for (int i = 0; i < kr.length; i++) {
                if (c == kr[i]) {
                    i = i+geser;
                    if (i>=kr.length) {
                        i=i-kr.length;
                    }
                    c = kr[i];
                    temp = temp + c;
                }
            }
        }
        
        System.out.println("Sebelum : "+text);
        System.out.println("Sesudah : "+temp);
    }
}
