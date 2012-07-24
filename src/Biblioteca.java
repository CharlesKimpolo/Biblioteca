import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Biblioteca {

    protected final PrintStream out;
    private final InputStream in;

    public Biblioteca(PrintStream out, InputStream in) {
        this.out = out;
        this.in = in;
    }

    public static void main(String[] args) {
        new Biblioteca(System.out, System.in).startApplication();
    }

    public void startApplication() {
        displayWelcomeMessage();
        displayListOfMenuOptions();
        performOption(getUserSelection());
    }

    protected void performOption(String userSelection) {
        // This space is intentionally blank
    }

    private void displayWelcomeMessage() {
        out.println("Welcome to Biblioteca");
    }

    private void displayListOfMenuOptions() {
        out.println("1) View all books");
    }

    private String getUserSelection() {
        out.println("Select an option");
        Scanner scanner = new Scanner(in);
        return scanner.nextLine();
    }
}
