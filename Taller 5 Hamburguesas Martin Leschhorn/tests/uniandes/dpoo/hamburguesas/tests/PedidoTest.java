package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uniandes.dpoo.hamburguesas.mundo.Pedido;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class PedidoTest {

    private Pedido pedido;
    private ProductoMenu hamburguesa;
    private ProductoMenu papas;

    @BeforeEach
    public void setUp() {
        pedido = new Pedido("Eugenio", "Calle 113");
        papas = new ProductoMenu("Papas Picantes", 9000);
        hamburguesa = new ProductoMenu("Hamburguesa Mexicana", 24000);
        
    }

    @Test
    public void testGenerarTextoFactura() {
        pedido.agregarProducto(hamburguesa);
        pedido.agregarProducto(papas);
        String factura = pedido.generarTextoFactura();
        
        assertTrue(factura.contains("Cliente: Eugenio"));
        assertTrue(factura.contains("Dirección: Calle 113"));
        assertTrue(factura.contains("Hamburguesa Mexicana"));
        assertTrue(factura.contains("Papas Picantes"));
        assertTrue(factura.contains("Precio Total"));
    }

    @Test
    public void testGuardarFactura() throws FileNotFoundException {
        pedido.agregarProducto(hamburguesa);
        pedido.agregarProducto(papas);
        File facturaArchivo = new File("factura_test.txt");
        pedido.guardarFactura(facturaArchivo);

        Scanner scanner = new Scanner(facturaArchivo);
        assertTrue(scanner.hasNextLine());
        scanner.close();

        facturaArchivo.delete();
    }
}
