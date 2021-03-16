/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author Sony
 */
public class Tokenizador {

    public  String archivo;
    public  int index = 0;
    public  String cad;
    
    public Tokenizador(){
        leerString();
        cad = "";
    }
    
    public void leerString(){
        String texto, aux;
        String lista = "";

        try {
            //llamamos el metodo que permite cargar la ventana           
            String directorio = new File("").getAbsolutePath();
            directorio += "\\";
            File file = new File(directorio + "Caracteres.txt");

            File abre = file;

            //recorremos el archivo y lo leemos
            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);

                while ((aux = lee.readLine()) != null) {
                    texto = aux;
                    lista += texto;
                }
                lee.close();
            }
              archivo = lista;
//            return lista;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);

        }
//        return null;
    }
    
    public char leer(){
        index ++;
        try{
            cad += archivo.charAt(index-1);
            return archivo.charAt(index-1);   
        }catch(Exception e){
            
        }
        return 0;
    }
    
    public void imprimir(){
        System.out.println(cad);
    }
    
    public String token(){
        try{
        String aux = "";
        String aux2 = "";
        //leer la primera letra
        aux += leer();
        index -= 1; 
        aux2 += leer(); 
        //verificar si cumple con alguna exprecion regular
        if(!valIden(aux) && !valDig(aux)){
            // en caso de que no, regresar el simbolo
            return aux;
        }
        //ciclo de lectura
        while(true){
            //leer la siguiente letra
            aux2 += leer();
            //Verificar que siga umpliendo con las expreciones
            if(!valIden(aux2) && !valDig(aux2)){
                //en caso de que no, regresamos el index y salimos
                //del ciclo de lectura
                index -= 1;
                break;
            }else{
                //en caso de que si, igualamos la cadena a regresar con aux2
                aux = aux2;
            }  
        }
        //regresamos la cadena
        return aux;       
        }catch(Exception e){
           //en caso de que ya no haya nada que leer
           return null; 
        }

    }
    
    public String token2(){
        try{
        String aux = "";
        String aux2 = "";
        //leer la primera letra
        aux += leer();
        index -= 1; 
        aux2 += leer(); 
        // detectar ==
        if(aux.contentEquals("=")){
            char next = leer();
            if(next == '='){
                return aux += next;
            }
            index -= 1;
        }
        //detectar <=
        if(aux.contentEquals("<") || aux.contentEquals(">")){
            char next = leer();
            if(next == '='){
                return aux += next;
            }
            index -= 1;
        }
        //verificar si cumple con alguna exprecion regular
        if(!(valIden2(aux)) && !(valDig2(aux))){
            // en caso de que no, regresar el simbolo
            return aux;
        }
        //ciclo de lectura
        while(true){
            //leer la siguiente letra
            aux2 += leer();
            //Verificar que siga umpliendo con las expreciones
            boolean num = valDig(aux2);
            if(!(valIden2(aux2)) && !(valDig(aux2))){
                //en caso de que no, regresamos el index y salimos
                //del ciclo de lectura
                if (aux2.endsWith(".")) {
                    
                }else{
                    index -= 1;
                    break;
                }               
            }else{
                //en caso de que si, igualamos la cadena a regresar con aux2                
                aux = aux2;
            }  
        }
        //regresamos la cadena
        return aux;       
        }catch(Exception e){
           //en caso de que ya no haya nada que leer
           return null; 
        }

    }
    
    public ArrayList<String> tokenizar(){
        ArrayList<String> lista = new ArrayList();
        StringTokenizer st = new StringTokenizer(cad, " ");

        while (st.hasMoreTokens()) {
            lista.add(st.nextToken());
        }
        
        ArrayList<String> lista2 = new ArrayList();
        String aux ;
        for (int i = 0; i < lista.size(); i++) {
            aux = lista.get(i);
            aux += " : ";
            if (valIden(lista.get(i))){
                aux += valIden(lista.get(i));
            }else aux += valDig(lista.get(i));
            lista2.add(aux);
        }
        return lista2;
    }
    
    public static boolean valIden(String stg){
        return stg.matches("^[a-zA-Z]{1}([a-zA-Z]|_|[0-9])*$");
    }
    
    public static boolean valIden2(String aux){
        int ca;
        for (int i = 0; i < aux.length(); i++) {
            ca = aux.charAt(i); //codigo asci

            if (aux.substring(i, i+1).matches("[a-zA-Z]")){ 
            }else if(ca == 95){
                        
            }else if(aux.substring(i, i+1).matches("[0-9]")){
                        
            }else{
                return false;
            }
        } 
        return true;
    }
    
    public static boolean valDig2(String aux){
        for (int i = 0; i < aux.length(); i++) {
            if (aux.substring(i, i+1).matches("[0-9]")) {
                
            }
            else{
                if(aux.substring(i, i+1).matches(".")){
                    for (int j = i+1; j < aux.length(); j++) {
                        if (aux.substring(j, j+1).matches("[0-9]")) {
                            
                        }else{
                            return false;
                        }           
                    }
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean valDig(String stg){
        return stg.matches("^[0-9]+(.[0-9]+)?$");
    }
    
    public static void main(String ag[]){
       Tokenizador t =  new Tokenizador();
       
        for (int j = 0; j < 50; j++) {
            String stg = t.token2();
            if((stg.length() > 0) && (!stg.contentEquals(" "))){
                System.out.println(stg);
            }
            
        }       
            
    }

}
