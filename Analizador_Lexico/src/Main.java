/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lector;

import java.util.ArrayList;

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
     for (int i =0; i< t.tabla().size(); i++){
            String tablita = t.tabla().get(i);
            System.out.println(tablita);
            
     }
      
    }
}
