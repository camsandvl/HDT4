import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class MenuTest {

    private Menu menu;

    @Before
    public void setUp() {
        menu = new Menu();
    }

    @Test
    public void testLeerArchivo() {
        String contenidoEsperado = "3 + 4 * 2 / ( 1 - 5 )";
        String contenidoLeido = null;
        try {
            contenidoLeido = menu.leerArchivo("C:\\Users\\males\\OneDrive\\Escritorio\\programas 2\\HDT4\\HDT4\\datos.txt");
        } catch (IOException e) {
            e.printStackTrace();
            fail("IOException fue lanzada");
        }
        assertEquals(contenidoEsperado, contenidoLeido);
    }
}
