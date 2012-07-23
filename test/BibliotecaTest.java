import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream out = new PrintStream(outContent);

    @Test
    public void shouldDisplayWelcomeMessage() throws Exception {
        new Biblioteca(out).displayWelcomeMessage();

        assertEquals("Welcome to Biblioteca", outContent.toString().trim());
    }

}

