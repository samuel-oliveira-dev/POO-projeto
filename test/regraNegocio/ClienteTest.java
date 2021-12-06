/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package regraNegocio;


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

    
    @Test
    public void testGetEmail() {
        cliente.setEmail("joao@gmail.com");
        assertEquals("joao@gmail.com", cliente.getEmail());
    }

    
    @Test
    public void testGetCpf() {
        cliente.setCpf("08476480520");
        assertEquals("08476480520", cliente.getCpf());
    }

   
    @Test
    public void testGetCep() {
        cliente.setCep("49140000");
        assertEquals("49140000", cliente.getCep());
    }

   
    @Test
    public void testGetNome() {
        cliente.setNome("Joao");
        assertEquals("Joao", cliente.getNome());
    }

    
    @Test
    public void testGetLogradouro() {
        cliente.setLogradouro("Rua C, 22");
        assertEquals("Rua C, 22", cliente.getLogradouro());
    }

    @Test
    public void testGetNumero() {
        cliente.setNumero("234");
        assertEquals("234", cliente.getNumero());
    }

    
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

    
    
    
}
