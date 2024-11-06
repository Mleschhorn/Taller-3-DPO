package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ComboTest {

    private Combo combo;
    private ProductoMenu hamburguesa;
    private ProductoMenu papas;
    private ArrayList<ProductoMenu> itemsCombo;

    @BeforeEach
    public void setUp() {
        hamburguesa = new ProductoMenu("Hamburguesa", 100000);
        papas = new ProductoMenu("Papas Fritas", 4000);
        itemsCombo = new ArrayList<>();
        itemsCombo.add(papas);
        itemsCombo.add(hamburguesa);
        combo = new Combo("Combo Supremo", 0.07, itemsCombo);
    }

    @Test
    public void testGetNombre() {
        assertEquals("Combo Supremo", combo.getNombre());
    }

    @Test
    public void testGetPrecio() {
        int precioSinDescuento = hamburguesa.getPrecio() + papas.getPrecio();
        int precioConDescuento = (int)(precioSinDescuento * (0.93));
        assertEquals(precioConDescuento, combo.getPrecio());
    }

    @Test
    public void testGenerarTextoFactura() {
        String expected = "Combo Combo Supremo\\n Descuento: 0.07\\n            " + combo.getPrecio() + "\\n";
        assertEquals(expected, combo.generarTextoFactura());
    }
}
