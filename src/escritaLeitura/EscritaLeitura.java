/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escritaLeitura;

import java.util.ArrayList;
import regraNegocio.Livro;

/**
 *
 * @author samuk
 */
public abstract class EscritaLeitura {
    
    
    abstract public void salvar(Cadastravel c);
    
    abstract public ArrayList buscar(String arg1, String arg2);
    
    abstract public ArrayList ler();

}