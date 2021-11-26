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
    
    private int qtdVendida;
    private Livro livro;
    private Cliente cliente;
    private Calendar  data = Calendar.getInstance();

    public Venda(int qtdVendida, Livro livro, Cliente cliente, Calendar data) {
        this.qtdVendida = qtdVendida;
        this.livro = livro;
        this.cliente = cliente;
        this.data = data;
    }
    
    public Venda(int qtdVendida, Livro livro, Calendar data){
        this.qtdVendida = qtdVendida;
        this.livro = livro;
        this.data = data;
    }
    
    public void vender(){
        
        int quantidade = this.livro.getQuantidade();
        String codigo = this.livro.getCodigo();
        EscritaLeituraLivro ell = new EscritaLeituraLivro();
       ArrayList<Livro> livros = ell.ler();
       Livro livro;
       
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
    

    public int getQtdVendida() {
        return qtdVendida;
    }

    public void setQtdVendida(int qtdVendida) {
        this.qtdVendida = qtdVendida;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Venda{" + "qtdVendida=" + qtdVendida + ", livro=" + livro.toString() + ", cliente=" + cliente.toString() + ", data=" + data + '}';
    }
    
    
    
    
    

}
