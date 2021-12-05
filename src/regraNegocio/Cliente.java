/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package regraNegocio;

import escritaLeitura.Cadastravel;
import java.io.Serializable;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author samuk
 */
public class Cliente implements Cadastravel, Serializable{
    
    
    private String nome;
    private String logradouro;
    private String email;
    private String cpf;
    private String cep;
    private String numero;
    JInternalFrame jf;

    public Cliente(String logradouro, String email, String cpf, String cep) {
        this.nome = nome;
        this.logradouro = logradouro;
        this.email = email;
        this.cpf = cpf;
        this.cep = cep;
    }

    public Cliente() {
    }
    
    

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
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    public void setJF(JInternalFrame jf){
        this.jf = jf;
    }
    
    public boolean isValidCpf(String cpf){
        boolean result  = false;
        DocumentUtil doc = new DocumentUtil();
        if(doc.isValidSsn(cpf)){
            result = true;
        } else {
            JOptionPane.showMessageDialog(jf, "CPF Invalido!");
        }
        
        return result;
    }
    
    public boolean isValidEamil(String email){
        boolean result = false;
        EmailAddressValidator eav = new EmailAddressValidator(email);
        try {
            eav.validate();
            result = true;
            
        } catch (ParseException ex) {
            
            JOptionPane.showMessageDialog(jf, "E-mail Invalido!");
        }
      return result;  
    }
    
    

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", logradouro=" + logradouro + ", email=" + email + ", cpf=" + cpf + ", cep=" + cep + '}';
    }

    
    
    
    
    
    
    
    
    
    /*public String salvar(){
        try {
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
*/
    
    /*private String undoMaskCpf(String arg){
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
*/
    
    /*public ArrayList<Cliente> busca(String parametro, String argumento) {
        
        Cliente cl = new Cliente();
        ArrayList<Cliente> resultado = new ArrayList<>();
        ArrayList<Cliente> clientes = cl.ler();
        
        
        
        for(Cliente c : clientes){
            if(parametro.equals("Nome") && c.getNome().toUpperCase().equals(argumento.toUpperCase())){
                resultado.add(c);
            } else {
                if(parametro.equals("CPF") && undoMaskCpf(c.getCpf()).equals(argumento)){
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
*/

    
    /*public ArrayList ler() {
        
        String path = System.getProperty("user.dir");
        path = path + "\\clientes.txt";
        ArrayList<Cliente> clientes = new ArrayList<>();
        //Cliente c = new Cliente();
        
        
        
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
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return clientes;
        
        
        
    }
*/
}
