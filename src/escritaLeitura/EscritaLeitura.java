/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escritaLeitura;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
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
    
    
    public int countLines(String filePath) throws FileNotFoundException, IOException{
        LineNumberReader reader = new LineNumberReader(new FileReader(filePath));
        int counter = 0;
        String linha = "";
        while((linha = reader.readLine())!= null){
            
        }
        counter = reader.getLineNumber();
        reader.close();
        return counter;
    }

}