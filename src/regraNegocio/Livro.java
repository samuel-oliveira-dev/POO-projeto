/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package regraNegocio;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import escritaLeitura.Cadastravel;
import escritaLeitura.EscritaLeituraLivro;

/**
 *
 * @author samuk
 */
public class Livro  implements Cadastravel{
    
    private String titulo;
    private String autor;
    private String paginas;
    private String isbn;
    private String editora;
    private String ano;
    private String edicao;
    private String codigo;
    private String categoria;
    private int quantidade;
    private double preco;
    

    
    public Livro(){
        
    }

    public Livro(String titulo, String autor, String paginas, String isbn, String editora, String ano, String edicao) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.isbn = isbn;
        this.editora = editora;
        this.ano = ano;
        this.edicao = edicao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
    
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }
    
    

    
    
    
  
    
    
    
    
   public void vender(String codigo, int quantidade) {
       EscritaLeituraLivro ell = new EscritaLeituraLivro();
       ArrayList<Livro> livros = ell.ler();
       
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
        
    
    
    
    
    /*public String salvar(){
        
        FileWriter fw;
        String path = System.getProperty("user.dir");
        path = path + "\\livros.txt";
        
        try {
            fw = new FileWriter(path, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(getTitulo()+","+getAutor()+","+getEditora()+"," +getCategoria()+ ","+ getIsbn()+","+getEdicao()+","
                    +getPaginas()+","+getAno()+","+getPreco()+","+getQuantidade()+","+getCodigo());
            pw.flush();
            pw.close();
            fw.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Livro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "Cadastrado com sucesso!";
    }
    */
    
    /*public ArrayList ler() 
    {
       
        ArrayList<Livro> livros = new ArrayList<>();
        String path = System.getProperty("user.dir");
        path = path + "\\livros.txt";
        
        
        try (BufferedReader br = new BufferedReader(new FileReader(path)))
        {
            String line = br.readLine();
            while(line != null)
            {
                
                
                String[] vect = line.split(",");
                String titulo = vect[0];
                String autor = vect[1];
                String editora = vect[2];
                String categoria = vect[3];
                String isbn = vect[4];
                String edicao = vect[5];
                String paginas = vect[6];
                String ano = vect[7];
                double preco = Double.parseDouble(vect[8]);
                int quantidade = Integer.parseInt(vect[9]) ;
                String codigo = vect[10];
                
                
                Livro livro = new Livro();
                livro.setAutor(autor);
                livro.setTitulo(titulo);
                livro.setEditora(editora);
                livro.setIsbn(isbn);
                livro.setEdicao(edicao);
                livro.setPaginas(paginas);
                livro.setAno(ano);
                livro.setPreco(preco);
                livro.setQuantidade(quantidade);
                livro.setCodigo(codigo);
                livro.setCategoria(categoria);
                
                livros.add(livro);
                
                line = br.readLine();
                
               


            
            } 
        
        
        } catch(IOException ex){
            System.out.print(ex.getMessage());
        }
        return livros;
        
        
     
    }
    /*
    
    
    /*public ArrayList busca(String categoria, String argumento){
        
        Livro livro = new Livro();
        ArrayList<Livro>  lista = livro.ler();
        ArrayList<Livro> resultado = new ArrayList<>();
        for(Livro l : lista){
            if(l.getAutor().toUpperCase().contains(argumento.toUpperCase()) && categoria.equals("Autor")){
                resultado.add(l);
            } else {
                if(l.getTitulo().toUpperCase().contains(argumento.toUpperCase()) && categoria.equals("Titulo")){
                    resultado.add(l);
                } else{
                    if(argumento.toUpperCase().equals(l.getCodigo().toUpperCase()) && categoria.equals("Codigo")){
                        resultado.add(l);
                    } else {
                        if(argumento.equals(l.getIsbn()) && categoria.equals("ISBN")){
                            resultado.add(l);
                        }
                    }
                }
            }
        }
        return resultado;
    }
    */

    @Override
    public String toString() {
        return "Livro{" + "titulo=" + titulo + ", autor=" + autor + ", paginas=" + paginas + ", isbn=" + isbn + ", editora=" + editora + ", ano=" + ano + ", edicao=" + edicao + ", codigo=" + codigo + ", categoria=" + categoria + ", quantidade=" + quantidade + ", preco=" + preco + '}';
    }

    
    
    
    
    
}
