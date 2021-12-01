/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escritaLeitura;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author samuk
 */
public class MyObjectOutputStream extends ObjectOutputStream{
    
    public MyObjectOutputStream() throws IOException{
        super();
    }
    
    public MyObjectOutputStream(OutputStream out)throws IOException{
        super(out);
    }
    
    @Override
    protected void writeStreamHeader() throws IOException{
        return ;
    }
    
    
    
    
}
