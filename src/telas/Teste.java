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
import regraNegocio.Cliente;

/**
 *
 * @author samuk
 */
public class Teste {
    public static void main(String[] agrs){
    
        EscritaLeituraCliente elc = new EscritaLeituraCliente();
        ArrayList<Cliente> clientes = elc.buscar("Todos", "");
        for(Cliente c:clientes){
            System.out.println(c.toString());
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
    
}
