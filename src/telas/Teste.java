/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telas;


import escritaLeitura.EscritaLeituraCliente;
import regraNegocio.Livro;
import java.util.ArrayList;
import java.util.Scanner;
import escritaLeitura.EscritaLeituraLivro;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import regraNegocio.Cliente;
import regraNegocio.EmailAddressValidator;
import regraNegocio.ValidacaoEntradas;
import regraNegocio.Venda;

/**
 *
 * @author samuk
 */
public class Teste {
    public static void main(String[] agrs) {
    EmailAddressValidator eav = new EmailAddressValidator("oliveirasamuel@gmail.com");
        try {
            eav.validate();
            System.out.println("OK");
        } catch (ParseException ex) {
            System.out.println("invalido");
        }
        
        
    }
    
    public static String undoMask(String palavra){
        String[] mask1 = palavra.split("\\.");
        
        String res = "";
        String resdef = "";
        
        for(int i = 0; i < mask1.length; ++i ){
            res = res + mask1[i];
        }
        
        String[] mask2 = res.split("-");
        
        for(int i = 0; i < mask2.length; i++){
            resdef = resdef + mask2[i];
        }
        
        
        
        return resdef;
    }
    static ObjectInputStream ois = null;
     public static void read() throws IOException{
       //ObjectInputStream ois = null;
       //FileInputStream fis = null;
       String path = System.getProperty("user.dir") + "\\vendas.ser";
       ArrayList<Venda> vendas = new ArrayList<>();
       try{
           FileInputStream fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
           Venda v = null;
           do{
               
               v = (Venda) ois.readObject();
               if(v != null){
                   vendas.add(v);
                   
                   
                
               
           }
           
       }while (v != null);
           //System.out.println(vendas.get());
       
    } catch(Exception ex){
        ex.printStackTrace();
    } finally{
           if(ois != null){
               ois.close();
           }
       }
    
   }
    
}
