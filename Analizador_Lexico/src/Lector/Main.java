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
        
        for (int j = 0; j < 100; j++) {
            String stg = t.validar();
            System.out.println(stg);
        }   
    }
}
