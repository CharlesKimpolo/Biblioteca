import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

    protected final PrintStream out;
    private final Library library;
    private final Scanner scanner;

    public Biblioteca() {
        this(System.out, System.in);
    }

    public Biblioteca(PrintStream printStream, InputStream inputStream) {
        this(printStream, inputStream, Factory.library());
    }

    public Biblioteca(PrintStream out, InputStream in, Library library) {
        this.out = out;
        this.library = library;
        this.scanner = new Scanner(in);
    }

    public static void main(String[] args) {
        new Biblioteca().startApplication();
    }

    public void startApplication() {
        displayWelcomeMessage();
        displayListOfMenuOptions();
        performOption(getValidInput());
    }

    public void displayWelcomeMessage() {
        out.println("Welcome to Biblioteca");
    }

    public void displayListOfMenuOptions() {
        out.println("1) View all books");
    }

    public String getUserSelection(String prompt) {
        out.println(prompt);
        return scanner.nextLine();
    }

    protected void performOption(String userSelection) {
        List<Book> books = library.getBooks();
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            out.println(i + 1 + ") " + book.getTitle() + " by " + book.getAuthor());
        }
    }

    public String getValidInput() {
        String input = getUserSelection("Select an option");
        while (!input.equals("1")) {
            input = getUserSelection("Select a valid option!!");
        }
        return input;
    }
}
