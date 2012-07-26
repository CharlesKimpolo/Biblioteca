import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BibliotecaFunctionalTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Biblioteca biblioteca;

    private static final String INVALID_OPTION = "123";
    private static final String VALID_OPTION = "1";

    @Before
    public void setUp() throws Exception {
        biblioteca = bibliotecaWithUserInput("userSelectedOption");
    }

    @Test
    public void testUserSelectingValidOptionFromMenu() throws Exception {
        biblioteca = bibliotecaWithUserInput(VALID_OPTION);
        biblioteca.startApplication();
        assertThat(outputFromConsole(), equalTo("Welcome to Biblioteca\n1) View all books\nSelect an option\n" + message(VALID_OPTION)));
    }

    @Test
    public void testUserSelectingInvalidOptionFromMenu() throws Exception {
        biblioteca = bibliotecaWithUserInput(INVALID_OPTION + "\n" + INVALID_OPTION + "\n" + VALID_OPTION);
        biblioteca.startApplication();
        assertThat(outputFromConsole(), equalTo("Welcome to Biblioteca\n1) View all books\nSelect an option\nSelect a valid option!!\nSelect a valid option!!\n" + message(VALID_OPTION)));
    }

    private String outputFromConsole() {
        return outContent.toString().trim();
    }

    private Biblioteca bibliotecaWithUserInput(String input) {
        return new Biblioteca(new PrintStream(outContent), new ByteArrayInputStream(input.getBytes())) {
            @Override
            protected void performOption(String userSelection) {
                out.println(message(userSelection));
            }
        };
    }

    private String message(String option) {
        return "Option '" + option + "' was selected by the user";
    }
}
