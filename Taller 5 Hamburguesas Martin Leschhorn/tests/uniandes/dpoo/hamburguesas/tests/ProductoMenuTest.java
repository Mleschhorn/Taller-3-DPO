package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ProductoMenuTest {

    private ProductoMenu producto;

    @BeforeEach
    public void setUp() {
        producto = new ProductoMenu("Hamburguesa Tropical", 9000);
    }

    @Test
    public void testGetNombre() {
        assertEquals("Hamburguesa Tropical", producto.getNombre());
    }

    @Test
    public void testGetPrecio() {
        assertEquals(9000, producto.getPrecio());
    }

    @Test
    public void testGenerarTextoFactura() {
        String expected = "Hamburguesa Tropical\\n            9000\\n";
        assertEquals(expected, producto.generarTextoFactura());
    }
}
