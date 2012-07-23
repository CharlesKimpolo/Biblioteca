import java.io.PrintStream;

public class Biblioteca {

    private final PrintStream out;

    public Biblioteca(PrintStream out) {
        this.out = out;
    }

    public static void main(String[] args){
        new Biblioteca(System.out).displayWelcomeMessage();
    }

    public void displayWelcomeMessage() {
        out.println("Welcome to Biblioteca");
    }

}
