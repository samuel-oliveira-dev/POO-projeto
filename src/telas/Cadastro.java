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
public interface Cadastro {
    
    public ArrayList busca(String parametro, String argumento);
    public String salvar();
    public ArrayList<Cadastro> ler();
    
    
}
