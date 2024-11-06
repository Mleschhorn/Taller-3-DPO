package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ProductoAjustadoTest {

    private ProductoAjustado productoAjustado;
    private ProductoMenu productoBase;



    @Test
    public void testGetNombre() {
    	productoBase = new ProductoMenu("Hamburguesa Mini", 15000);
        productoAjustado = new ProductoAjustado(productoBase);
        assertEquals("Hamburguesa Mini", productoAjustado.getNombre());
    }

    @Test
    public void testGetPrecioSinModificaciones() {
        assertEquals(0, productoAjustado.getPrecio());
    }

    @Test
    public void testGenerarTextoFacturaSinModificaciones() {
        String expected = "Hamburguesa Mini\\n            0\\n";
        assertEquals(expected, productoAjustado.generarTextoFactura());
    }
}
