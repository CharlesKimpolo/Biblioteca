import java.io.*;

public class Biblioteca {

    private final PrintStream out;
    private final InputStream in;

    public Biblioteca(PrintStream out, InputStream in) {
        this.out = out;
        this.in = in;
    }

    public static void main(String[] args){
        new Biblioteca(System.out, System.in).startApplication();
    }

    public void startApplication() {
        displayWelcomeMessage();
        displayListOfMenuOptions();
        displayUserMenuOptionInput();
    }

    private void displayWelcomeMessage() {
        out.println("Welcome to Biblioteca");
    }

    private void displayListOfMenuOptions() {
        out.println("1) View all books");
    }

    private void displayUserMenuOptionInput() {
        out.println(getUserSelection());
    }

    private String getUserSelection() {
        InputStreamReader streamReader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(streamReader);
        String userSelection = null;
        try {
            userSelection = bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Unexpected IO Error reading from InputStream " + in.toString(), e);
        }
        return userSelection;
    }
}
