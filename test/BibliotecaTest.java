import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;

public class BibliotecaTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Biblioteca biblioteca;

    Library library = mock(Library.class);

    private static final String INVALID_OPTION = "123";
    private static final String VIEW_BOOKS_OPTION = "1";

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
        biblioteca = bibliotecaWithUserInput(VIEW_BOOKS_OPTION);

        String input = biblioteca.getUserSelection("Select an option");

        assertThat(outputFromConsole(), equalTo("Select an option"));
        assertThat(input, equalTo(VIEW_BOOKS_OPTION));
    }

    @Test
    public void shouldKeepAskingForInputUntilItIsValid() throws Exception {
        biblioteca = bibliotecaWithUserInput(INVALID_OPTION + "\n" + INVALID_OPTION + "\n" + VIEW_BOOKS_OPTION);
        String input = biblioteca.getValidInput();

        assertThat(outputFromConsole(), equalTo("Select an option\nSelect a valid option!!\nSelect a valid option!!"));
        assertThat(input, equalTo(VIEW_BOOKS_OPTION));
    }

    @Test
    public void shouldDisplayAllBooksInLibrary() throws Exception {
        stub(library.getBooks()).toReturn(Arrays.asList(new Book("First Book", "First Author"), new Book("Second Book", "Second Author")));

        biblioteca.performOption(VIEW_BOOKS_OPTION);

        assertThat(outputFromConsole(), equalTo("1) First Book by First Author\n2) Second Book by Second Author"));
    }

    private String outputFromConsole() {
        return outContent.toString().trim();
    }

    private Biblioteca bibliotecaWithUserInput(String input) {
        return new Biblioteca(new PrintStream(outContent), new ByteArrayInputStream(input.getBytes()), library);
    }

}

