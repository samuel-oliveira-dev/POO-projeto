/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package regraNegocio;

import regraNegocio.Livro;
import java.util.ArrayList;
import escritaLeitura.Cadastravel;
import java.util.Date;

/**
 *
 * @author samuk
 */
public class Venda implements Cadastravel{
    
    private int qtdVendida;
    private Livro livro;
    private Cliente cliente;
    private Date data;

    public Venda(int qtdVendida, Livro livro, Cliente cliente, Date data) {
        this.qtdVendida = qtdVendida;
        this.livro = livro;
        this.cliente = cliente;
        this.data = data;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
    
    
    

}
