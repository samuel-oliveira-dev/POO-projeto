/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escritaLeitura;

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

    private final String PATH = System.getProperty("user.dir")+"\\livros.txt";
    ObjectOutputStream oos = null;
    FileOutputStream fos = null;
    FileInputStream fis = null;
    ObjectInputStream ois = null;
    
    
    
    public void vender(Livro livro, int quantidade){
        
        //int quantidade = livro.getQuantidade();
        String codigo = livro.getCodigo();
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
           System.out.println(ex);
       }
       
    }
    
    
    public void save(Cadastravel c) throws IOException{
        Venda v = ((Venda)c);
        String path = System.getProperty("user.dir") + "\\vendas.ser";
        //FileOutputStream fos = null;
        //ObjectOutputStream oos = null;
        
        try {
            fos = new FileOutputStream(path,true);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(v);
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally{
            if(oos != null){
                oos.close();
            }
        }
        
        
    }
    
    
    @Override
    public void salvar(Cadastravel c) {
        if(c instanceof Venda){
            Venda venda = ((Venda) c);
            
        String path = System.getProperty("user.dir");
        path = path + "\\vendas.txt";
        String caminho = System.getProperty("user.dir") + "\\vendas.ser";
        FileOutputStream fos;
        Livro livro = venda.getLivro();
        Cliente cliente = venda.getCliente();
        
        try {
            fos = new FileOutputStream(path, true);
            PrintStream ps = new PrintStream(fos);
           
            
            String autor = livro.getAutor();
            String titulo = livro.getTitulo();
            String isbn = livro.getIsbn();
            int qtdVenda = venda.getQtdVendida();
            String cod = livro.getCodigo();
            Calendar data = venda.getData();
            int dia = data.get(Calendar.DAY_OF_MONTH);
            int mes = data.get(Calendar.MONTH) + 1;
            int ano = data.get(Calendar.YEAR);
            int hora = data.get(Calendar.HOUR_OF_DAY);
            int minuto = data.get(Calendar.MINUTE);
            int segundo = data.get(Calendar.SECOND);
            
            String dataCompleta = String.format("%02d/%02d/%d at %02d:%02d:%02d", dia,mes,ano,hora,minuto,segundo);
            venda.setDataStr(dataCompleta);
            
            
             String lineSeparator = System.getProperty("line.separator");
            ps.println(titulo+","+autor+","+isbn+","+cod+","+qtdVenda+","+dataCompleta);
           
            ps.close();
            
            
        }   catch (IOException ex) {
                Logger.getLogger(EscritaLeituraVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        
        }
        
        
    }

    @Override
    public ArrayList buscar(String arg1, String arg2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList ler() {
        try {
            FileInputStream fis = new FileInputStream(PATH);
            Scanner input = new Scanner(fis);
            while(input.hasNext()){
                String[] vect = input.nextLine().split(",");
                String titulo = vect[0];
                String autor = vect[1];
                String codigo = vect[2];
                String isbn = vect[3];
                int qtd = Integer.parseInt(vect[4]);
                String dataStr = vect[3];
                
                
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EscritaLeituraVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return null;
        
    }
    
    public void read() throws IOException{
       //ObjectInputStream ois = null;
       //FileInputStream fis = null;
       String path = System.getProperty("user.dir") + "\\vendas.ser";
       ArrayList<Venda> vendas = new ArrayList<>();
       try{
           fis = new FileInputStream(path);
           ois = new ObjectInputStream(fis);
           Venda v = null;
           do{
               ois.readObject();
               v = (Venda) ois.readObject();
               if(v != null){
                   vendas.add(v);
                   
                   
                
               
           }
           
       }while (v != null);
           //System.out.println(vendas.get());
       
    } catch(Exception ex){
        ex.printStackTrace();
    } finally{
           if(ois != null){
               ois.close();
           }
       }
    
   }
}    
