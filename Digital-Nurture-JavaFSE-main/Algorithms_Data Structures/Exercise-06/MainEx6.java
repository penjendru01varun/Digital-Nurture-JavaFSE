import java.util.Arrays;
import java.util.Comparator;

public class MainEx6 {
    public static void main(String[] args) {
        Book[] books = {
            new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book("B002", "1984", "George Orwell"),
            new Book("B003", "To Kill a Mockingbird", "Harper Lee"),
            new Book("B004", "Pride and Prejudice", "Jane Austen"),
            new Book("B005", "Moby-Dick", "Herman Melville")
        };

        String searchTitle = "1984";

        System.out.println("--- Linear Search ---");
        Book foundByLinear = Library.linearSearchByTitle(books, searchTitle);
        if (foundByLinear != null) {
            System.out.println("Found: " + foundByLinear);
        } else {
            System.out.println("Book not found.");
        }

        System.out.println("\nSorting books by title for binary search...");
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getTitle().compareToIgnoreCase(b2.getTitle());
            }
        });

        System.out.println("\n--- Binary Search ---");
        Book foundByBinary = Library.binarySearchByTitle(books, searchTitle);
        if (foundByBinary != null) {
            System.out.println("Found: " + foundByBinary);
        } else {
            System.out.println("Book not found.");
        }
    }
}
