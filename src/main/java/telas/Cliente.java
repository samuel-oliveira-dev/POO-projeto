/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samuk
 */
public class Cliente {
    
    
    private String nome;
    private String data;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    private String logradouro;
    private String email;
    private String cpf;
    private String cep;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    
    
    
    
    public String salvar(){
        
        
        //FileWriter fw = new FileWriter("dados/clientes.txt", true);
        try {
            
            //FileWriter fw = new FileWriter("C:\\Users\\Valter\\Documents\\NetBeansProjects\\CloneMainPOO\\src\\main\\java\\POO-projeto\\dados\\clientes.txt", true);
            // C:\Users\Valter\Documents\NetBeansProjects\CloneMainPOO\src\main\java\POO-projeto\dados
            String s = System.getProperty("user.dir");
            s = s + "\\clientes.txt";
            FileWriter fw = new FileWriter(s, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(getNome()+","+getEmail()+","+getCpf()+","+getLogradouro()+","+getCep());
            pw.flush();
            pw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Cadastrado com sucesso!";
    }
}