import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BibliotecaTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Biblioteca biblioteca;

    @Before
    public void setUp() throws Exception {
        biblioteca = bibliotecaWithUserInput(" ");
    }

    @Test
    public void shouldDisplayWelcomeMessage() throws Exception {
        biblioteca.startApplication();

        assertThat(linesFromConsole()[0], equalTo("Welcome to Biblioteca"));
    }

    @Test
    public void shouldDisplayListOfMenuOptions() throws Exception {
        biblioteca.startApplication();

        assertThat(linesFromConsole()[1], equalTo("1) View all books"));
    }

    private String[] linesFromConsole() {
        return outContent.toString().split("\n");
    }

    @Test
    public void shouldAllowUserToSelectMenuOption() throws Exception {
        biblioteca = bibliotecaWithUserInput("123");

        biblioteca.startApplication();
        assertThat(linesFromConsole()[2], equalTo("Select an option"));
        assertThat(linesFromConsole()[3], equalTo("123"));
    }

    private Biblioteca bibliotecaWithUserInput(String input) {
        return new Biblioteca(new PrintStream(outContent), new ByteArrayInputStream(input.getBytes()));
    }

}

