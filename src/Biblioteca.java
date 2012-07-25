import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Biblioteca {

    protected final PrintStream out;
    private final Scanner scanner;

    public Biblioteca(PrintStream out, InputStream in) {
        this.out = out;
        this.scanner = new Scanner(in);
    }

    public static void main(String[] args) {
        new Biblioteca(System.out, System.in).startApplication();
    }

    public void startApplication() {
        displayWelcomeMessage();
        displayListOfMenuOptions();
        validateUserInput(getUserSelection());
    }

    public void validateUserInput(String userSelection) {
        if (!userSelection.equals("1")) {
            out.println("Select a valid option!!");
        }
    }

    public void displayWelcomeMessage() {
        out.println("Welcome to Biblioteca");
    }

    public void displayListOfMenuOptions() {
        out.println("1) View all books");
    }

    public String getUserSelection() {
        out.println("Select an option");
        return scanner.nextLine();
    }
}
