import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    public final PrintStream out = new PrintStream(outContent);

    @Before
    public void setUp() throws Exception {
    System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }

    @Test
    public void shouldDisplayWelcomeMessage() throws Exception {
        Biblioteca.main(null);
        assertEquals("Welcome to Biblioteca", outContent.toString().trim());
    }

}

