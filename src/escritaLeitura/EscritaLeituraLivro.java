/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escritaLeitura;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import regraNegocio.Livro;

/**
 *
 * @author samuk
 */
public class EscritaLeituraLivro extends EscritaLeitura implements Deletavel{
    
   public final String PATH = System.getProperty("user.dir") + "\\livros.txt";
   public final String PATH_EXC = System.getProperty("user.dir") + "\\livrosExc.txt";

    public String getPATH() {
        return PATH;
    }

    public String getPATH_EXC() {
        return PATH_EXC;
    }
   
   

    @Override
    public ArrayList buscar(String categoria, String argumento) {
        
         
        //Livro livro = new Livro();
        ArrayList<Livro>  lista = ler(PATH);
        ArrayList<Livro> resultado = new ArrayList<>();
        for(Livro l : lista){
            if(l.getAutor().toUpperCase().contains(argumento.toUpperCase()) && categoria.equals("Autor")){
                resultado.add(l);
            } else {
                if(l.getTitulo().toUpperCase().contains(argumento.toUpperCase()) && categoria.equals("Titulo")){
                    resultado.add(l);
                } else{
                    System.out.println("Array: "+l.getCodigo());
                    System.out.println("Arg:"+argumento);
                    if(argumento.equals(l.getCodigo()) && categoria.equals("Codigo")){
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
    public ArrayList ler(String path) {
        ArrayList<Livro> livros = new ArrayList<>();
        String[] array = null;
        try{
            InputStream is = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int i = 0;
            while((i = is.read()) != -1){
                baos.write((byte) i);

            }
            is.close();
        Stream<String> stream  = baos.toString().lines();
        array = stream.toArray(String[] :: new);
        
            
        } catch(Exception ex){
            ex.printStackTrace();
        }
        for(int i = 0; i < array.length; ++i){
            
            String[] vect = array[i].split(",");
            String titulo = vect[0];
            String autor = vect[1];
            String editora = vect[2];
            String categoria = vect[3];
            String codigo = vect[4];
            String edicao = vect[5];
            String paginas = vect[6];
            String ano = vect[7];
            double preco = Double.parseDouble(vect[8]);
            int quantidade = Integer.parseInt(vect[9]) ;
            String isbn = vect[10];
            System.out.println(preco);
            System.out.println(quantidade);
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
 
        }
        
        return livros;
        
        
    }

    @Override
    public void salvar(Cadastravel c, String path) {
        if(c instanceof Livro){
            Livro l = ((Livro) c);
            
        try {
           OutputStream os = new FileOutputStream(path, true);
           PrintStream ps = new PrintStream(os);
           ps.println(l.getTitulo()+","+l.getAutor()+","+l.getEditora()+"," +l.getCategoria()+ ","+ l.getIsbn()+","+l.getEdicao()+","
                    +l.getPaginas()+","+l.getAno()+","+l.getPreco()+","+l.getQuantidade()+","+l.getCodigo());
 
               
 
           
           ps.flush();
           ps.close();
           
       } catch (FileNotFoundException ex) {
           ex.printStackTrace();
       }
 
        }
    }

    @Override
    public boolean deletar(String arg) {
        ArrayList<Livro> livros = ler(PATH);
        ArrayList<Livro> res = new ArrayList<>();
        ArrayList<Livro> excluidos = new ArrayList<>();
        File file = new File(PATH);
        boolean status = false;
        
        for(Livro l:livros){
            if(l.getCodigo().equals(arg) == false){
                res.add(l);
                status = true;
            } else {
                excluidos.add(l);
                status = true;
            }
        }
       
        file.delete();
        
        Path pathToFile = Paths.get(PATH);
       try {
           Files.createDirectories(pathToFile.getParent());
           Files.createFile(pathToFile);
       } catch (IOException ex) {
           Logger.getLogger(EscritaLeituraLivro.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        
        
        for(Livro l: res){
            salvar(l,PATH);
        }
        
        for(Livro l:excluidos){
            salvar(l,PATH_EXC);
        }
       
       
       
            
            
       
        
        
        
        
        
        
        return status;
    }

    @Override
    public ArrayList getDeletados() {
        ArrayList<Livro> livros = ler(PATH_EXC);
        return livros;
    }
    
    public boolean exists(String cod){
        boolean res = buscar("Codigo", cod).size() > 0? true:false;
        
        return res;
    }

    
    
}
