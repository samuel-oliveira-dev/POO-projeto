/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package regraNegocio;

import com.wojcikiewicz.isbn.ISBN;
import javax.swing.JOptionPane;
import escritaLeitura.Cadastravel;
import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParsePosition;
import javax.swing.JInternalFrame;

/**
 *
 * @author samuk
 */
public class Livro  implements Cadastravel, Serializable, Validavel{
    
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
    private JInternalFrame jf;
    

    
    public Livro(){
        
    }

    public JInternalFrame getJf() {
        return jf;
    }

    public void setJf(JInternalFrame jf) {
        this.jf = jf;
    }
    
    

    /*public Livro(String titulo, String autor, String paginas, String isbn, String editora, String ano, String edicao) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.isbn = isbn;
        this.editora = editora;
        this.ano = ano;
        this.edicao = edicao;
    }*/

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


    @Override
    public String toString() {
        return "Livro{" + "titulo=" + titulo + ", autor=" + autor + ", paginas=" + paginas + ", isbn=" + isbn + ", editora=" + editora + ", ano=" + ano + ", edicao=" + edicao + ", codigo=" + codigo + ", categoria=" + categoria + ", quantidade=" + quantidade + ", preco=" + preco + '}';
    }

    @Override
    public boolean checkFields() {
        boolean res = verifyEmpty() || verifyNumericFields() || isValidIsbn();
        
        
        return res;
    }
    
    private boolean verifyEmpty(){
        boolean res = true;
        if(this.autor.isBlank() || this.titulo.isBlank() || this.ano.isBlank()
                || this.codigo.isBlank() || this.editora.isBlank()
                || this.edicao.isBlank() || this.isbn.isBlank()){
            JOptionPane.showMessageDialog(jf, "Campos Vazios nao sao permitidos");
            res = false;
        }
        
        return res;
    }
    
    private boolean isValidIsbn(){
        if(ISBN.isValid(isbn) == false){
            JOptionPane.showMessageDialog(jf, "ISBN Invalido!");
            
        }
        
        return ISBN.isValid(isbn);
    }
    
     public boolean checkNumeric(String str){
        
        boolean res = false;
        for(int i = 0; i<str.length();++i){
            
            String a = String.valueOf(str.charAt(i));
            if(isNumeric(a)){
                res = true;
            } 
        }

        return res;
    }
     
     public boolean isNumeric(String str) {
       ParsePosition pos = new ParsePosition(0);
       NumberFormat.getInstance().parse(str, pos);
       return str.length() == pos.getIndex();
    }
     
     public boolean verifyNumericFields(){
            boolean res = true;
            if(this.quantidade == -1){
                res = false;
                JOptionPane.showMessageDialog(jf, "Valor de Quantidade Invalido!");
            }
            if(this.preco == -1){
                JOptionPane.showMessageDialog(jf, "Valor de Preco Invalido!");
                res = false;
            }
            if(checkNumeric(this.paginas) == false){
                 JOptionPane.showMessageDialog(jf, "Valor de Paginas Invalido!");
                 res = false;
            }
            if(checkNumeric(this.ano) == false){
                JOptionPane.showMessageDialog(jf, "Valor de Ano Invalido!");
                res = false;
                
            }
            
            return res;
            
        }
        
    
    

    
    
    
    
    
}
