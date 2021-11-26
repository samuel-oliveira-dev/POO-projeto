/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package regraNegocio;
import br.com.caelum.stella.validation.AcceptAnyValidator;
import javax.swing.JOptionPane;
/**
 *
 * @author samuk
 */
public class ValidacaoEntradas {
    
    //String entrada;
    
    
    public boolean isCampoVazio(String str){
        
        boolean res;
        if(str.equals("")){
            res =  false;
        } else{
            res = true;
        }
        return res;
        
       
        
        
    }

    
    public boolean isNumeric(String num){
        
        boolean res = false;
        
        
        
        return res;
        
    }
   
    
    

    

}
