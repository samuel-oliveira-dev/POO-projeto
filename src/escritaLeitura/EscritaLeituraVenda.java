/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escritaLeitura;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import regraNegocio.Cliente;
import regraNegocio.Livro;
import regraNegocio.Venda;

/**
 *
 * @author samuk
 */
public class EscritaLeituraVenda extends EscritaLeitura implements Serializable{

    private final String PATH = System.getProperty("user.dir")+"\\vendas.txt";
    
    
    
    public void vender(String codLivro, int quantidade){
        
        //int quantidade = livro.getQuantidade();
        String codigo = codLivro;
        EscritaLeituraLivro ell = new EscritaLeituraLivro();
        ArrayList<Livro> livros = ell.ler();
       //Livro livro;
       
       for(Livro l:livros){
           if(codigo.equals(l.getCodigo())){
               if(quantidade <= l.getQuantidade()){
                   l.setQuantidade(l.getQuantidade() - quantidade);
                   JOptionPane.showMessageDialog(null, "Compra concluída!");
               } else {
                   JOptionPane.showMessageDialog(null, "Estoque insuficiente,por favor revise o pedido.");
               }
                   
               
           }
       }
       
       for(Livro l:livros){
           System.out.println(l.toString());
       }
       
       String path = System.getProperty("user.dir");
       path = path + "\\livros.txt";
       FileWriter fw; 
       try{
           fw = new FileWriter(path);
           
           for(Livro l:livros){
               String line = (l.getTitulo()+","+l.getAutor()+","+l.getEditora()+"," +l.getCategoria()+ ","+ l.getIsbn()+","+l.getEdicao()+","
                    +l.getPaginas()+","+l.getAno()+","+l.getPreco()+","+l.getQuantidade()+","+l.getCodigo());
               fw.write(line + System.lineSeparator());
           }
           fw.close();
       }catch(IOException ex){
           ex.printStackTrace();
       }
       
    }
    
    
    public void save(Cadastravel c){
        Venda v = ((Venda)c);
        String path = System.getProperty("user.dir") + "\\vendas.ser";
        ArrayList<Venda> venda = new ArrayList<>();
        venda.add(v);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
          fos = new FileOutputStream(path, true);
          oos = new ObjectOutputStream(fos);
          oos.writeObject(venda);
          
            
        } catch(Exception ex){
            ex.printStackTrace();
        } finally{
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(EscritaLeituraVenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
       
        
        
    }
    
    public void read() {
         String path = System.getProperty("user.dir") + "\\vendas.ser";
         ObjectInputStream ois = null;
         //ArrayList<ArrayList<Venda>> vendas = new ArrayList<>();
          ArrayList vendas = new ArrayList();
        try{
            FileInputStream fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
            ArrayList<Venda> venda;
           
            do {
                venda = (ArrayList<Venda>) ois.readObject();
                vendas.add(venda);
            } while(venda != null);
            
            
            
            
            
        } catch(Exception ex){
            ex.printStackTrace();
        } finally{
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException ex) {
                    Logger.getLogger(EscritaLeituraVenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //return vendas;
         
        
    }
    
    
    @Override
    public void salvar(Cadastravel c) {
        if(c instanceof Venda){
            Venda venda = ((Venda) c);
            
        EscritaLeituraLivro ell = new EscritaLeituraLivro();
        //EscritaLeituraCliente elc = new EscritaLeituraCliente();
        FileOutputStream fos;
        String codLivro = venda.getCodLivro();
        String cpfCliente = venda.getCpfCliente();
        
        
        try {
            fos = new FileOutputStream(PATH, true);
            PrintStream ps = new PrintStream(fos);
            ArrayList<Livro> livro = ell.buscar("Codigo", codLivro);
            //Cliente cliente = (Cliente) elc.buscar("CPF", cpfCliente).get(0);
           
            
            String autor = livro.get(0).getAutor();
            String titulo = livro.get(0).getTitulo();
            String isbn = livro.get(0).getIsbn();
            int qtdVenda = venda.getQtdLivroVendida();
            String cod = livro.get(0).getCodigo();
            String data = venda.getData();
            
            
            
             
            ps.println(titulo+","+autor+","+isbn+","+cod+","+cpfCliente+","+qtdVenda+","+data);
            System.out.println("Gravado!");
           
            ps.close();
            
            
        }   catch (IOException ex) {
                Logger.getLogger(EscritaLeituraVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        
        }
        
        
    }

    @Override
    public ArrayList buscar(String arg1, String arg2) {
        ArrayList<Venda> vendas = ler();
        ArrayList<Venda> resultado = new ArrayList<>();
        
        for(Venda v:vendas){
            if(arg1.equals("Todos")){
                resultado = vendas;
            } else {
                if(arg1.equals("CPF") && arg2.equals(v.getCpfCliente())){
                    resultado.add(v);
                }
            }
        }
        
        return resultado;
        
        
    }

    @Override
    public ArrayList ler() {
        ArrayList<Venda> vendas = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(PATH);
            Scanner input = new Scanner(fis);
            
            while(input.hasNext()){
                String[] vect = input.nextLine().split(",");
                String titulo = vect[0];
                String autor = vect[1];
                String codigo = vect[2];
                String isbn = vect[3];
                String cpf = vect[4];
                int qtd = Integer.parseInt(vect[5]);
                String data = vect[6];
                
                Venda venda = new Venda (codigo,cpf,qtd,data,isbn,titulo, autor);
                vendas.add(venda);
                
                
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EscritaLeituraVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(Venda v:vendas){
            System.out.println(v.toString());
        }
        
        return vendas;
        
    }
    
    
}    
