/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escritaLeitura;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import regraNegocio.Livro;

/**
 *
 * @author samuk
 */
public class EscritaLeituraLivro extends EscritaLeitura{
    
   

    @Override
    public ArrayList buscar(String categoria, String argumento) {
        
         
        Livro livro = new Livro();
        ArrayList<Livro>  lista = ler();
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

    @Override
    public ArrayList ler() {
        
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

    @Override
    public void salvar(Cadastravel c) {
        if(c instanceof Livro){
            Livro l = ((Livro) c);
            FileWriter fw;
        String path = System.getProperty("user.dir");
        path = path + "\\livros.txt";
        
        
        try {
            fw = new FileWriter(path, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(l.getTitulo()+","+l.getAutor()+","+l.getEditora()+"," +l.getCategoria()+ ","+ l.getIsbn()+","+l.getEdicao()+","
                    +l.getPaginas()+","+l.getAno()+","+l.getPreco()+","+l.getQuantidade()+","+l.getCodigo());
            pw.flush();
            pw.close();
            fw.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Livro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        }
    }

    
    
}
