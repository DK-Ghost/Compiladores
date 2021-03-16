/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lector;

/**
 *
 * @author Sony
 */
public class Main {
    public static void main(String ag[]){
        Tokenizador t = new Tokenizador();
        
       for (int j = 0; j < 50; j++) {
            String stg = t.token2();
            System.out.println(stg);
        }   
    }
}
