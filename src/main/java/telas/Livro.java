/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telas;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samuk
 */
public class Livro extends Produto {
    
    private String titulo;
    private String autor;
    private String paginas;
    private String isbn;
    private String editora;
    private String ano;
    private String edicao;

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
            pw.println(getTitulo()+","+getAutor()+","+getEditora()+","+getIsbn()+","+getEdicao()+","
                    +getPaginas()+","+getAno()+","+getPreco()+","+getQuantidade()+","+getCodigo());
            pw.flush();
            pw.close();
            fw.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Livro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "Cadastrado com sucesso!";
    }
    
    
    
    
}
