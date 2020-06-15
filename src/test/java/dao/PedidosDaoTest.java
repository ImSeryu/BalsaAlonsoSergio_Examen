/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author seryu
 */
public class PedidosDaoTest {
    
    public PedidosDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getConexion method, of class PedidosDao.
     */
   
    
    @Test
    public void testGetConexion() {
        System.out.println("getConexion");
        PedidosDao instance = new PedidosDao();
        Connection expResult = null;
        Connection result = instance.getConexion();
        assertNotEquals(expResult, result);
        
    }

    /**
     * Test of read method, of class PedidosDao.
    */
    
    @Test
    public void testRead() {
        System.out.println("read");
        PedidosDao instance = new PedidosDao();
        Integer idPedido = 11070;
        Pedido expResult = null;
        Pedido result = instance.read(idPedido);
        assertNotEquals(expResult, result);
        
        //PRUEBA LEER UN PEDIDO QUE NO EXISTA
        idPedido = 1;
        expResult = null;
        result = instance.read(idPedido);
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of insert method, of class PedidosDao.
    */
    @Test
    public void testInsert() {
        System.out.println("insert");
        PedidosDao instance = new PedidosDao();
        BigDecimal bd = new BigDecimal(5.2500);
        Date date1 = new Date(1998,05,06);
        Pedido pedido = new Pedido(1,65,1,date1,date1,date1,2,bd,"Sergio","dsajdasdsa","dsajdasdsa","dsajdasdsa","dsajdasdsa","dsajdasdsa");
        Integer expResult = 0;
        Integer result = instance.insert(pedido);
        assertNotEquals(expResult, result);
        
        instance.delete(result);
        
        // PRUEBA INSERTAR PEDIDO CON ERROR
        Pedido pedido2 = new Pedido(11081,65,1,date1,date1,date1,4,bd,"Sergio","dsajdasdsa","dsajdasdsa","dsajdasdsa","dsajdasdsa","dsajdasdsa");
        expResult = null;
        result = instance.insert(pedido2);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of update method, of class PedidosDao.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        PedidosDao instance = new PedidosDao();
        
        BigDecimal bd = new BigDecimal(5.2500);
        Date date1 = new Date(1998,05,06);
        Pedido pedido = new Pedido(0,65,1,date1,date1,date1,2,bd,"Sergio","dsajdasdsa","dsajdasdsa","dsajdasdsa","dsajdasdsa","dsajdasdsa");
        Integer id = instance.insert(pedido);
        Pedido pedidoModificado = new Pedido(id,90,3,date1,date1,date1,1,bd,"Sergio","modificado","dsajdasdsa","dsajdasdsa","dsajdasdsa","dsajdasdsa");
        Integer expResult = 1;
        Integer result = instance.update(pedidoModificado);
        assertEquals(expResult, result);
        
        //ACTUALIZACION CON ERRORES
        Pedido pedidoModificado2 = new Pedido(id,90,3,date1,date1,date1,4,bd,"Sergio","modificado","dsajdasdsa","dsajdasdsa","dsajdasdsa","dsajdasdsa");
        expResult = null;
        result = instance.update(pedidoModificado2);
        
        instance.delete(id);
    }

    /**
     * Test of delete method, of class PedidosDao.
    */ 
    @Test
    public void testDelete() {
        System.out.println("delete");
        PedidosDao instance = new PedidosDao();
        BigDecimal bd = new BigDecimal(5.2500);
        Date date1 = new Date(1998,05,06);
        Pedido pedido = new Pedido(1,65,1,date1,date1,date1,2,bd,"Sergio","dsajdasdsa","dsajdasdsa","dsajdasdsa","dsajdasdsa","dsajdasdsa");
        Integer id = instance.insert(pedido);
        Integer idPedido = id;
        Integer expResult = 1;
        Integer result = instance.delete(idPedido);
        assertEquals(expResult, result);
        
        //ELIMINAR UN PEDIDO QUE NO SE PUEDA BORRAR
        idPedido = 1276;
        expResult = 0;
        result = instance.delete(idPedido);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of listar method, of class PedidosDao.
    */ 
    @Test
    public void testListar() {
        System.out.println("listar");
        Integer posicion = 1;
        PedidosDao instance = new PedidosDao();
        ArrayList<Pedido> expResult = null;
        ArrayList<Pedido> result = instance.listar(posicion);
        assertNotEquals(expResult, result);
        
    }
    
}
