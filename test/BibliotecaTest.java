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

    private static final String INVALID_OPTION = "123";
    private static final String VALID_OPTION = "1";

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
        biblioteca = bibliotecaWithUserInput(VALID_OPTION);

        biblioteca.startApplication();

        String[] lines = linesFromConsole();
        assertThat(lines[lines.length - 2], equalTo("Select an option"));
        assertThat(lines[lines.length - 1], equalTo(VALID_OPTION));
    }

    @Test
    public void shouldValidateUserInput() throws Exception {
        biblioteca = bibliotecaWithUserInput(INVALID_OPTION);

        biblioteca.startApplication();

        String[] lines = linesFromConsole();
        assertThat(lines[lines.length - 1], equalTo("Select a valid option!!"));
    }

    private Biblioteca bibliotecaWithUserInput(String input) {
        return new Biblioteca(new PrintStream(outContent), new ByteArrayInputStream(input.getBytes())) {
            @Override
            protected void performOption(String userSelection) {
                out.println(userSelection);
            }
        };
    }

}

