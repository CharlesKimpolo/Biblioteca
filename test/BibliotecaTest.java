import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Biblioteca biblioteca;

    @Before
    public void setUp() throws Exception {
        biblioteca = new Biblioteca(new PrintStream(outContent));
    }

    @Test
    public void shouldDisplayWelcomeMessage() throws Exception {
        biblioteca.displayWelcomeMessage();

        assertEquals("Welcome to Biblioteca", outContent.toString().trim());
    }

    @Test
    public void shouldDisplayListOfMenuOptions() throws Exception {
        biblioteca.displayListOfMenuOptions();

        assertEquals("1) View all books", outContent.toString().trim());
    }
}

