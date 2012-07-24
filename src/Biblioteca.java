import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Biblioteca {

    private final PrintStream out;
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
        String userSelection = getUserSelection();

        out.println(userSelection);
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
