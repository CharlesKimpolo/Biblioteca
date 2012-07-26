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
        biblioteca.displayWelcomeMessage();

        assertThat(outputFromConsole(), equalTo("Welcome to Biblioteca"));
    }

    @Test
    public void shouldDisplayListOfMenuOptions() throws Exception {
        biblioteca.displayListOfMenuOptions();

        assertThat(outputFromConsole(), equalTo("1) View all books"));
    }

    @Test
    public void shouldAllowUserToSelectMenuOption() throws Exception {
        biblioteca = bibliotecaWithUserInput(VALID_OPTION);

        String input = biblioteca.getUserSelection("Select an option");

        assertThat(outputFromConsole(), equalTo("Select an option"));
        assertThat(input, equalTo(VALID_OPTION));
    }

    @Test
    public void shouldKeepAskingForInputUntilItIsValid() throws Exception {
        biblioteca = bibliotecaWithUserInput(INVALID_OPTION + "\n" + INVALID_OPTION + "\n" + VALID_OPTION);
        String input = biblioteca.getValidInput();

        assertThat(outputFromConsole(), equalTo("Select an option\nSelect a valid option!!\nSelect a valid option!!"));
        assertThat(input, equalTo(VALID_OPTION));
    }

    private String outputFromConsole() {
        return outContent.toString().trim();
    }

    private Biblioteca bibliotecaWithUserInput(String input) {
        return new Biblioteca(new PrintStream(outContent), new ByteArrayInputStream(input.getBytes()));
    }

}

