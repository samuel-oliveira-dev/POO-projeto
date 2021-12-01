/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escritaLeitura;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import regraNegocio.Cliente;

/**
 *
 * @author samuk
 */
public class EscritaLeituraCliente extends EscritaLeitura {
    
    private final String PATH = System.getProperty("user.dir") + "\\clientes.txt";

    @Override
    public void salvar(Cadastravel c) {
        
        Cliente cl = ((Cliente) c);
        
        
        try {
            
            String s = System.getProperty("user.dir");
            s = s + "\\clientes.txt";
            FileWriter fw = new FileWriter(s, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(cl.getNome()+","+cl.getEmail()+","+cl.getCpf()+","+cl.getLogradouro()+","+cl.getCep());
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
        path = path + "\\clientes.txt";
        ArrayList<Cliente> clientes = new ArrayList<>();
        
        
        
        
        try(BufferedReader br = new BufferedReader(new FileReader(path)))
        {
            
            String line = br.readLine();
            
            
            while(line != null){
            String[] vect = line.split(",");
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
            System.out.println(ex);
        }
        
        
        return clientes;
        
    }
    
    public void removerCliente(String cpf){
        
        ArrayList<Cliente> clientes = ler();
        ArrayList<Cliente> res = new ArrayList<Cliente>();
        for(Cliente c:clientes){
            if(cpf.equals(c.getCpf())){
                clientes.remove(c);
            }
        }
        
        FileWriter fw;
        
        
            
             
            try {
               fw = new FileWriter(PATH);
               PrintWriter pw = new PrintWriter(fw);
                for(Cliente cl:clientes){
                    
                    System.out.println(cl.toString());
                    pw.write(cl.getNome()+","+cl.getEmail()+","+cl.getCpf()+","+cl.getLogradouro()+","+cl.getCep());
                    //fw.write(line + System.lineSeparator());
                    
                }
                
                fw.close();
                pw.close();
                
                
                
                
                
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(EscritaLeituraCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        
        
    }
    
}
