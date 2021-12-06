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
    public void salvar(Cadastravel c, String path) {
        Cliente cl = ((Cliente) c);
        try {
            FileWriter fw = new FileWriter(path, true);
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
        ArrayList<Cliente> clientes = ler(PATH);
        
        
        
        for(Cliente c : clientes){
            if(parametro.equals("Nome") && c.getNome().toUpperCase().contains(argumento.toUpperCase())){
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
    public ArrayList ler(String path) {
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
        ArrayList<Cliente> clientes = ler(PATH);
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
        File file2 = new File(PATH);

        for(Cliente c:clientes){
            salvar(c,PATH);
        }

        return val;
        
    }
    
   

    @Override
    public boolean deletar(String cpf) {
        
        boolean val = false;
        ArrayList<Cliente> clientes = ler(PATH);
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
        File file2 = new File(PATH);
        file2.delete();
        for(Cliente c:res){
            salvar(c,PATH);
        }
        
        for(Cliente c:excluidos){
            salvar(c,PATH_EXC);
        }
        return val ;
        
    }

    @Override
    public ArrayList getDeletados() {
        ArrayList<Cliente> excluidos = ler(PATH_EXC);

        return excluidos;
        
    }
    
    public boolean exists(String cpf){
        boolean res = buscar("CPF", cpf).size() > 0? true:false;
        
        return res;
    }
    
}
