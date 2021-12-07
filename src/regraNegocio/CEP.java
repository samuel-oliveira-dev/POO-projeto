/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package regraNegocio;

/**
 *
 * @author samuk
 */
public class CEP {
    
    public boolean isValidCEP(String cep){
    
        
        return  cep.matches("\\d{5}-\\d{3}");
    }
    
    
}
