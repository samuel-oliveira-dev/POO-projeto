/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package regraNegocio;

import java.text.NumberFormat;
import java.text.ParsePosition;
import javax.swing.JOptionPane;
/**
 *
 * @author samuk
 */
public class ValidacaoEntradas {
    
    //String entrada;
    public boolean isNumeric(String str) {
       ParsePosition pos = new ParsePosition(0);
       NumberFormat.getInstance().parse(str, pos);
       return str.length() == pos.getIndex();
    }
    
    public boolean isCampoVazio(String str){
        
        boolean res;
        if(str.equals("")){
            res =  false;
        } else{
            res = true;
        }
        return res;
        
       
        
        
    }
    public boolean checkName(String str){
        
        boolean res = true;
        for(int i = 0; i<str.length();++i){
            
            String a = String.valueOf(str.charAt(i));
            if(isNumeric(a)){
                res = false;
            } 
        }
        
        
        return res;
    }

    
   
    
    

    

}
