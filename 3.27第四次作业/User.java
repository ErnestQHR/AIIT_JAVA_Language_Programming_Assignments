import java.util.ArrayList;
import java.util.List;

public class User extends Person {
    private List<Book> borrowedBooks;

    public User(int id, String name, String contact) {
        super(id, name, contact);
        this.borrowedBooks = new ArrayList<>();
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.setAvailable(false);
            System.out.println(getName() + " borrowed: " + book.getTitle());
        } else {
            System.out.println("Book is not available for borrowing!");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setAvailable(true);
            System.out.println(getName() + " returned: " + book.getTitle());
        } else {
            System.out.println("You did not borrow this book!");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("User: " + super.toString());
        System.out.println("Borrowed Books: " + borrowedBooks.size());
    }
}