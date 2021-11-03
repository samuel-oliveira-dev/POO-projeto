/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Valter
 */
public class Usuario {
    private String nome;
    private String senha;
    private String tipo;

    public Usuario(String nome, String senha, String tipo) {
        this.nome = nome;
        this.senha = senha;
        this.tipo = tipo;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String salvar(){
        try {
            // Digitar diretório do seu pc:
            FileWriter fw = new FileWriter("C:\\Users\\Valter\\Documents\\NetBeansProjects\\CloneMainPOO\\src\\main\\java\\POO-projeto\\dados\\usuarios.txt", true);
            
            PrintWriter pw = new PrintWriter(fw);
            pw.println(getNome()+","+getSenha()+","+getTipo());
            pw.flush();
            pw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Cadastrado com sucesso!";
    }
    
}
