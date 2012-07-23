import java.io.PrintStream;

public class Biblioteca {

    private final PrintStream out;

    public Biblioteca(PrintStream out) {
        this.out = out;
    }

    public static void main(String[] args){
        new Biblioteca(System.out).startApplication();
    }

    public void startApplication() {
        displayWelcomeMessage();
        displayListOfMenuOptions();
    }

    private void displayWelcomeMessage() {
        out.println("Welcome to Biblioteca");
    }

    private void displayListOfMenuOptions() {
        out.println("1) View all books");
    }

}
