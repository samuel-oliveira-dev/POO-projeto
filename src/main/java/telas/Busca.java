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
public class Busca extends Livro{
    private Livro livro = new Livro();
    private ArrayList<Livro>  lista = livro.ler();
    
    private ArrayList<Livro> resultado = new ArrayList<>();
    
    public ArrayList<Livro> buscar(String categoria, String argumento){
        for(Livro l : lista){
            if(categoria.equals("Autor") && (l.getAutor().equals(argumento))){
                resultado.add(l);
            }
        }
        return resultado;
    }
    
    
    
    
    
    
    
    
    
}
