/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package regraNegocio;

import javax.swing.JInternalFrame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author samuk
 */
public class ClienteTest {
    
    private Cliente cliente;
    
    public ClienteTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
       
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        cliente = new Cliente();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getEmail method, of class Cliente.
     */
    @Test
    public void testGetEmail() {
        cliente.setEmail("joao@gmail.com");
        assertEquals("joao@gmail.com", cliente.getEmail());
    }

    /**
     * Test of setEmail method, of class Cliente.
     */
    
    /**
     * Test of getCpf method, of class Cliente.
     */
    @Test
    public void testGetCpf() {
        cliente.setCpf("08476480520");
        assertEquals("08476480520", cliente.getCpf());
    }

    /**
     * Test of setCpf method, of class Cliente.
     */
    
    /**
     * Test of getCep method, of class Cliente.
     */
    @Test
    public void testGetCep() {
        cliente.setCep("49140000");
        assertEquals("49140000", cliente.getCep());
    }

    /**
     * Test of setCep method, of class Cliente.
     */
   
    /**
     * Test of getNome method, of class Cliente.
     */
    @Test
    public void testGetNome() {
        cliente.setNome("Joao");
        assertEquals("Joao", cliente.getNome());
    }

    /**
     * Test of setNome method, of class Cliente.
     */
    

    /**
     * Test of getLogradouro method, of class Cliente.
     */
    @Test
    public void testGetLogradouro() {
        cliente.setLogradouro("Rua C, 22");
        assertEquals("Rua C, 22", cliente.getLogradouro());
    }

    /**
     * Test of setLogradouro method, of class Cliente.
     */
    
    

    /**
     * Test of getNumero method, of class Cliente.
     */
    @Test
    public void testGetNumero() {
        cliente.setNumero("234");
        assertEquals("234", cliente.getNumero());
    }

    /**
     * Test of setNumero method, of class Cliente.
     */
    
    /**
     * Test of setJF method, of class Cliente.
     */
   

    /**
     * Test of isValidCpf method, of class Cliente.
     */
    @Test
    public void testIsValidCpf() {
        assertEquals(false, cliente.isValidCpf("123456789101"));
        assertEquals(true, cliente.isValidCpf("84594376045"));
        
        
    }

    /**
     * Test of isValidEamil method, of class Cliente.
     */
    @Test
    public void testIsValidEamil() {
        assertEquals(true, cliente.isValidEamil("joao@gmail.com"));
        assertEquals(false, cliente.isValidEamil("joaogmail"));
        assertEquals(false, cliente.isValidEamil("joaogmail$563"));
        
    }

    /**
     * Test of toString method, of class Cliente.
     */
    
    
}
