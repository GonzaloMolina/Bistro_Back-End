package Bistro_BackEnd.model.Orden;

import Bistro_BackEnd.model.consumibles.Bebida;
import Bistro_BackEnd.model.consumibles.Plato;
import Bistro_BackEnd.model.consumibles.TamanioBebida;
import Bistro_BackEnd.model.mesa.Mesa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class OrdenTest {

    private Orden ord = new Orden();
    private Orden ord1;
    private List<Bebida> bebidas = new ArrayList<>();
    private List<Bebida> drinks = new ArrayList<>();
    private List<Plato> platos = new ArrayList<>();

    @BeforeEach
    void setUp(){
        ord1 = new Orden(bebidas, platos);
        drinks.add(new Bebida("", TamanioBebida.CHICO, 600.0,0.0));
    }

    @Test
    void test_00_construrtorVacio(){
        assertNull(ord.getId());
        assertNull(ord.getBebidas());
        assertNull(ord.getPlatos());
    }

    @Test
    void test_01_constructorParametrizado(){
        assertNull(ord1.getId());
        assertEquals(ord1.getBebidas(), bebidas);
        assertEquals(ord1.getPlatos(), platos);
    }

    @Test
    void test_02_setId(){
        ord1.setId(1L);
        assertEquals(ord1.getId(), 1L);
    }


    @Test
    void test_04_setBebidas(){
        ord.setBebida(bebidas);
        assertEquals(ord.getBebidas(), bebidas);
    }

    @Test
    void test_05_setPlatos(){
        ord.setPlato(platos);
        assertEquals(ord.getPlatos(), platos);
    }

    @Test
    void test_06_calcularCuenta(){
        ord.setBebida(drinks);
        ord.setPlato(platos);
        assertEquals(ord.calcularCuenta(), 600.0);
    }
}
