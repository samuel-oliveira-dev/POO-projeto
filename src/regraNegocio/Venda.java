/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package regraNegocio;

import regraNegocio.Livro;
import java.util.ArrayList;
import escritaLeitura.Cadastravel;
import escritaLeitura.EscritaLeituraLivro;
import escritaLeitura.EscritaLeituraVenda;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author samuk
 */
public class Venda implements Cadastravel, Serializable {
    private static final long serialVersionUID = 4440897898944013059L;
    
    private String codLivro;
    private int qtdLivroVendida;
    private String isbn;
    private String autor;
    private String titulo;
    private float total;
    private String FormaPagamento;
    private String cpfCliente;
    private String data;

    public Venda(String cpfCliente, float total, String FormaPagamento) {
        this.cpfCliente = cpfCliente;
        this.total = total;
        this.FormaPagamento = FormaPagamento;
        this.data = generateData();
    }

    public Venda(float total, String FormaPagamento, String cpfCliente, String data) {
        this.total = total;
        this.FormaPagamento = FormaPagamento;
        this.cpfCliente = cpfCliente;
        this.data = data;
    }
    
    private String generateData(){
       
        Calendar data = Calendar.getInstance();
        int dia = data.get(Calendar.DAY_OF_MONTH);
        int mes = data.get(Calendar.MONTH) + 1;
        int ano = data.get(Calendar.YEAR);
        int hora = data.get(Calendar.HOUR_OF_DAY);
        int minuto = data.get(Calendar.MINUTE);
        int segundo = data.get(Calendar.SECOND);
            
        String res = String.format("%02d/%02d/%d as %02d:%02d:%02d", dia,mes,ano,hora,minuto,segundo);
        
        
        
        return res;
        
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getFormaPagamento() {
        return FormaPagamento;
    }

    public void setFormaPagamento(String FormaPagamento) {
        this.FormaPagamento = FormaPagamento;
    }

    
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
    

    
    public String getCodLivro() {
        return codLivro;
    }

    public void setCodLivro(String codLivro) {
        this.codLivro = codLivro;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public int getQtdLivroVendida() {
        return qtdLivroVendida;
    }

    public void setQtdLivroVendida(int qtdLivroVendida) {
        this.qtdLivroVendida = qtdLivroVendida;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Venda{" + "codLivro=" + codLivro + ", cpfCliente=" + cpfCliente + ", qtdLivroVendida=" + qtdLivroVendida + ", data=" + data + ", isbn=" + isbn + ", autor=" + autor + ", titulo=" + titulo + '}';
    }

    

    

    
    
    
    
    

}
