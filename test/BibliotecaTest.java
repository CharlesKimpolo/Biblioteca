import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BibliotecaTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Biblioteca biblioteca;

    @Before
    public void setUp() throws Exception {
        biblioteca = new Biblioteca(new PrintStream(outContent));

    }

    @Test
    public void shouldDisplayWelcomeMessage() throws Exception {
        biblioteca.startApplication();

        assertThat(outContent.toString().split("\n")[0], equalTo("Welcome to Biblioteca"));
    }

    @Test
    public void shouldDisplayListOfMenuOptions() throws Exception {
        biblioteca.startApplication();

        assertThat(outContent.toString().split("\n")[1], equalTo("1) View all books"));
    }
}

