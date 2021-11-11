/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telas;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samuk
 */
public class Livro  {
    
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

    
    
    
  
    
    
    
    
   
        
    
    
    
    
    public String salvar(){
        
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
    
    
    public ArrayList<Livro> ler() 
    {
        ArrayList<String[]> lista = new ArrayList<String[]>();
        ArrayList<Livro> livros = new ArrayList<>();
        String path = System.getProperty("user.dir");
        path = path + "\\livros.txt";
        String[] conteudo = new String[10];
        
        try (BufferedReader br = new BufferedReader(new FileReader(path)))
        {
            String line = br.readLine();
            while(line != null)
            {
                
                
                String[] vect = line.split(",");
                String autor = vect[0];
                String titulo = vect[1];
                String editora = vect[2];
                String isbn = vect[3];
                String edicao = vect[4];
                String paginas = vect[5];
                String ano = vect[6];
                double preco = Double.parseDouble(vect[7]);
                int quantidade = Integer.parseInt(vect[8]) ;
                String codigo = vect[9];
                lista.add(conteudo);
                
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
                
                livros.add(livro);
                
                line = br.readLine();
                
                /*Livro livro = new Livro();
                
                livro.setTitulo(titulo);
                livro.setAutor(autor);
                livro.setEditora(editora);
                livro.setIsbn(isbn);
                livro.setEdicao(edicao);
                livro.setPaginas(paginas);
                livro.setAno(ano);
                livro.setPreco(preco);
                livro.setQuantidade(qtd);
                livro.setCodigo(cod);
                
                livros.add(livro);
*/


            
            } 
        
        
        } catch(IOException ex){
            System.out.print(ex.getMessage());
        }
        return livros;
        
        
        
    
        
        
    }

    @Override
    public String toString() {
        return "Livro{" + "titulo=" + titulo + ", autor=" + autor + ", paginas=" + paginas + ", isbn=" + isbn + ", editora=" + editora + ", ano=" + ano + ", edicao=" + edicao + '}';
    }
    
    
    
    
}
