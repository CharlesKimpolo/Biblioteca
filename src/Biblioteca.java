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
        // TO BE IMPLEMENTED
    }

    public String getValidInput() {
         String input = getUserSelection("Select an option");
         while (!input.equals("1")) {
            input = getUserSelection("Select a valid option!!");
         }
        return input;
    }
}
