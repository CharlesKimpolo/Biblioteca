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
    private static final String VIEW_BOOKS_OPTION = "1";

    @Before
    public void setUp() throws Exception {
        biblioteca = bibliotecaWithUserInput("userSelectedOption");
    }

    @Test
    public void testUserSelectingValidOptionFromMenu() throws Exception {
        biblioteca = bibliotecaWithUserInput(VIEW_BOOKS_OPTION);
        biblioteca.startApplication();
        assertThat(outputFromConsole(), equalTo(new String[]{
                "Welcome to Biblioteca",
                "1) View all books",
                "Select an option",
                message(VIEW_BOOKS_OPTION),
                "1) Robin Hood by Kevin Reynolds",
                "2) StrengthsFinder 2.0 by Tom Rath",
                "3) The Fallen Angel: A Novel by Daniel Silva"
        }));
    }

    @Test
    public void testUserSelectingInvalidOptionFromMenu() throws Exception {
        biblioteca = bibliotecaWithUserInput(INVALID_OPTION + "\n" + INVALID_OPTION + "\n" + VIEW_BOOKS_OPTION);
        biblioteca.startApplication();
        assertThat(outputFromConsole(), equalTo(new String[]{
                "Welcome to Biblioteca",
                "1) View all books",
                "Select an option",
                "Select a valid option!!",
                "Select a valid option!!",
                message(VIEW_BOOKS_OPTION),
                "1) Robin Hood by Kevin Reynolds",
                "2) StrengthsFinder 2.0 by Tom Rath",
                "3) The Fallen Angel: A Novel by Daniel Silva"
        }));
    }

    private String[] outputFromConsole() {
        return outContent.toString().trim().split("\n");
    }

    private Biblioteca bibliotecaWithUserInput(String input) {
        return new Biblioteca(new PrintStream(outContent), new ByteArrayInputStream(input.getBytes())) {
            @Override
            protected void performOption(String userSelection) {
                out.println(message(userSelection));
                super.performOption(userSelection);
            }
        };
    }

    private String message(String option) {
        return "Option '" + option + "' was selected by the user";
    }
}
