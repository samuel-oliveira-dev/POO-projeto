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
    
    //private ArrayList<Livro> resultado = new ArrayList<>();
    
    public ArrayList<Livro> buscar(String categoria, String argumento){
        ArrayList<Livro> resultado = new ArrayList<>();
        for(Livro livro : lista){
            if(argumento.toUpperCase().equals(livro.getAutor().toUpperCase()) && categoria.equals("Autor")){
                resultado.add(livro);
            } else {
                if(argumento.toUpperCase().equals(livro.getTitulo().toUpperCase()) && categoria.equals("Titulo")){
                    resultado.add(livro);
                } else{
                    if(argumento.toUpperCase().equals(livro.getCodigo().toUpperCase()) && categoria.equals("Codigo")){
                        resultado.add(livro);
                    } else {
                        if(argumento.equals(livro.getIsbn()) && categoria.equals("ISBN")){
                            resultado.add(livro);
                        }
                    }
                }
            }
        }
        return resultado;
    }
    
   
    
    
    
    
    
    
    
    
    
}
