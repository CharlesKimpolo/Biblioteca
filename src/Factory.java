import java.util.Arrays;
import java.util.List;

public class Factory {
    static Library library() {
        return new Library(books());
    }

    private static List<Book> books() {
        return Arrays.asList(
                new Book("Robin Hood", "Kevin Reynolds"),
                new Book("StrengthsFinder 2.0", "Tom Rath"),
                new Book("The Fallen Angel: A Novel", "Daniel Silva")
        );
    }
}
