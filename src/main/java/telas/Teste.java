/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telas;

import java.util.ArrayList;

/**
 *
 * @author samuk
 */
public class Teste {
    public static void main(String[] args){
        
        
        Livro livro = new Livro();
        Busca busca = new Busca();
        
        ArrayList<Livro> resultado = busca.buscar("Autor", "Machado de Assis");
        
        
        ArrayList<Livro> list = livro.ler();
        
        for(Livro l : resultado){
            System.out.println(l.toString());
        }
        
        
    }
}
