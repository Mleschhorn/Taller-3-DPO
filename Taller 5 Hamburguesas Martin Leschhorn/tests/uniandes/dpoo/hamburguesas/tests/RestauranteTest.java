package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uniandes.dpoo.hamburguesas.excepciones.NoHayPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.excepciones.YaHayUnPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.excepciones.HamburguesaException;
import uniandes.dpoo.hamburguesas.mundo.Restaurante;

public class RestauranteTest {

    private Restaurante restaurante;

    @BeforeEach
    public void setUp() {
        restaurante = new Restaurante();
    }

    @Test
    public void testIniciarPedido() throws YaHayUnPedidoEnCursoException {
        restaurante.iniciarPedido("Yesith Jimenez", "Calle 51");
        assertEquals("Yesith Jimenez", restaurante.getPedidoEnCurso().getNombreCliente());
    }

    @Test
    public void testIniciarPedidoException() throws YaHayUnPedidoEnCursoException {
        restaurante.iniciarPedido("Yesith Jimenez", "Calle 51");
        assertThrows(YaHayUnPedidoEnCursoException.class, () -> {
            restaurante.iniciarPedido("Carlos Guachi", "Calle 912");
        });
    }

    @Test
    public void testCerrarYGuardarPedidoException() {
        assertThrows(NoHayPedidoEnCursoException.class, () -> {
            restaurante.cerrarYGuardarPedido();
        });
    }

    @Test
    public void testCargarInformacionRestaurante() throws IOException, HamburguesaException {
        File archivoIngredientes = new File("data/ingredientes.txt");
        File archivoMenu = new File("data/menu.txt");
        File archivoCombos = new File("data/combos.txt");

        restaurante.cargarInformacionRestaurante(archivoIngredientes, archivoMenu, archivoCombos);

        assertEquals(3, restaurante.getIngredientes().size());
        assertEquals(5, restaurante.getMenuBase().size());
        assertEquals(2, restaurante.getMenuCombos().size());
    }
}
