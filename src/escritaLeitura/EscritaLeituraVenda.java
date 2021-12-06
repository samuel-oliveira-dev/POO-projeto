/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escritaLeitura;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
public class EscritaLeituraVenda extends EscritaLeitura implements Cadastravel{

    public final String PATH = System.getProperty("user.dir")+"\\vendas.txt";
    
    
    
    public void vender(String codLivro, int quantidade){
        
        //int quantidade = livro.getQuantidade();
        String codigo = codLivro;
        EscritaLeituraLivro ell = new EscritaLeituraLivro();
        ArrayList<Livro> livros = ell.ler(ell.PATH);
        File file = new File(ell.PATH);
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
       
       
       file.delete();
       Path pathToFile = Paths.get(ell.PATH);
        try {
            Files.createDirectories(pathToFile.getParent());
            Files.createFile(pathToFile);
        } catch (IOException ex) {
            Logger.getLogger(EscritaLeituraVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       
       for(Livro l:livros){
           ell.salvar(l,ell.PATH);
       }
       
    }
    
    
    
    
    
    
    
    @Override
    public void salvar(Cadastravel c, String path) {
        if(c instanceof Venda){
            Venda venda = ((Venda) c);
            
        EscritaLeituraLivro ell = new EscritaLeituraLivro();
        //EscritaLeituraCliente elc = new EscritaLeituraCliente();
        FileOutputStream fos;
        String codLivro = venda.getCodLivro();
        String cpfCliente = venda.getCpfCliente();
        
        
        try {
            fos = new FileOutputStream(path, true);
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
        ArrayList<Venda> vendas = ler(PATH);
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
    public ArrayList ler(String path) {
        ArrayList<Venda> vendas = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
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
