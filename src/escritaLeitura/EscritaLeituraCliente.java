/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escritaLeitura;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import regraNegocio.Cliente;

/**
 *
 * @author samuk
 */
public class EscritaLeituraCliente extends EscritaLeitura implements Deletavel{
    
    public final String PATH = System.getProperty("user.dir") + "\\clientes.txt";
    public final String PATH_EXC = System.getProperty("user.dir") + "\\clienteExc.txt";
    
    
    
    public long getSizeFile(String path){
        File file = new File(path);
        long size = file.length();
        
        return size;
        
    }
    

    @Override
    public void salvar(Cadastravel c) {
        Cliente cl = ((Cliente) c);
        try {
            FileWriter fw = new FileWriter(PATH, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(cl.getNome()+"|"+cl.getEmail()+"|"+cl.getCpf()+"|"+cl.getLogradouro()+"|"+cl.getCep());
            pw.flush();
            pw.close();
            fw.close();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    
    public String undoMaskCpf(String arg){
        String[] mask1 = arg.split("\\.");
        
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

    @Override
    public ArrayList buscar(String parametro, String argumento) {
        
        Cliente cl = new Cliente();
        ArrayList<Cliente> resultado = new ArrayList<>();
        ArrayList<Cliente> clientes = ler();
        
        
        
        for(Cliente c : clientes){
            if(parametro.equals("Nome") && c.getNome().toUpperCase().equals(argumento.toUpperCase())){
                resultado.add(c);
            } else {
                if(parametro.equals("CPF") && undoMaskCpf(c.getCpf()).equals(undoMaskCpf(argumento))){
                    resultado.add(c);
                } else {
                    if(parametro.equals("Todos")){
                        resultado = resultado;
                    }
                }
            }
        }
        
        return resultado;
    }
    

    @Override
    public ArrayList ler() {
        String path = System.getProperty("user.dir");
        ArrayList<Cliente> clientes = new ArrayList<>();
        
        
        
        
        try(BufferedReader br = new BufferedReader(new FileReader(PATH)))
        {
            
            File arq = new File(path);
            
            String line = br.readLine();
            

            while(line != null){
                String[] vect = line.split("\\|");
                String nome  = vect[0];
                String email = vect[1];
                String cpf = vect[2];
                String logradouro = vect[3];
                String cep = vect[4];
            
                Cliente c = new Cliente();
                 c.setNome(nome);
                 c.setEmail(email);
                 c.setLogradouro(logradouro);
                 c.setCep(cep);
                 c.setCpf(cpf);
            
                 clientes.add(c);
                 line = br.readLine();
            
            
               }
  
           
          } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
        return clientes;
        
    }
    
    public boolean editarCliente(String logradouro, String email, String cpf, String cep){
        boolean val = false;
        //Cliente mudanca = new Cliente(email, cpf, cep);
        ArrayList<Cliente> clientes = ler();
        for(Cliente cl:clientes){
            
            if(cpf.equals(cl.getCpf())){
                cl.setLogradouro(logradouro);
                cl.setEmail(email);
                cl.setCep(cep);
                
                val = true;
                
            }
        }
        File file = new File(PATH);
        file.delete();

        FileWriter fw;

            try {
               fw = new FileWriter(PATH,true);
               
               BufferedWriter br = new BufferedWriter(fw);
                for(Cliente cl:clientes){
                    
                    br.write(cl.getNome()+"|"+cl.getEmail()+"|"+cl.getCpf()+"|"+cl.getLogradouro()+"|"+cl.getCep());
                    br.newLine();
                    
                }

                br.close();
                fw.close();
                
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(EscritaLeituraCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }

        return val;
        
    }
    
   

    @Override
    public boolean deletar(String cpf) {
        
        boolean val = false;
        ArrayList<Cliente> clientes = ler();
        ArrayList<Cliente> res = new ArrayList<>();
        ArrayList<Cliente> excluidos = new ArrayList<>();
        File file = new File(PATH);
        for(Cliente c:clientes){
            
            if(cpf.equals(c.getCpf()) == false){
                res.add(c);
                val = true;
                
            } else {
                
                excluidos.add(c);
                val = true;
                
            }
        }
        
        
        file.delete();
        
        FileWriter fw;        
                       
            try {
               fw = new FileWriter(PATH,true);
               
               BufferedWriter br = new BufferedWriter(fw);
               
                for(Cliente cl:res){
                    
                    
                    br.write(cl.getNome()+"|"+cl.getEmail()+"|"+cl.getCpf()+"|"+cl.getLogradouro()+"|"+cl.getCep());
                    br.newLine();
                    
                    
                }
                
                
                br.close();
                fw.close();                
                
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(EscritaLeituraCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            
            FileWriter fw2;
            
            
            try{
                fw2 = new FileWriter(PATH_EXC, true);
                BufferedWriter br2 = new BufferedWriter(fw2);
                for(Cliente c:excluidos){
                    
                    br2.write(c.getNome()+"|"+c.getEmail()+"|"+c.getCpf()+"|"+c.getLogradouro()+"|"+c.getCep());
                    br2.newLine();
                }
                br2.close();
                fw2.close();
                
            } catch (IOException ex) {
            java.util.logging.Logger.getLogger(EscritaLeituraCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return val ;
        
    }

    @Override
    public ArrayList getDeletados() {
        ArrayList<Cliente> excluidos = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(PATH_EXC))){
            
            String line = br.readLine();
            

            while(line != null){
                String[] vect = line.split("\\|");
                String nome  = vect[0];
                String email = vect[1];
                String cpf = vect[2];
                String logradouro = vect[3];
                String cep = vect[4];
            
                Cliente c = new Cliente();
                 c.setNome(nome);
                 c.setEmail(email);
                 c.setLogradouro(logradouro);
                 c.setCep(cep);
                 c.setCpf(cpf);
            
                 excluidos.add(c);
                 line = br.readLine();
            
            
               }
            
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return excluidos;
        
    }
    
}
