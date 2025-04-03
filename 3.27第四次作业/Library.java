import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library implements ILibraryOperations {
    private List<Book> books;
    private List<User> users;
    private Map<String, Integer> categorySummary; // 统计每个类别的图书数量

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.categorySummary = new HashMap<>();
    }

    @Override
    public void addBook(Book book) {
        books.add(book);

        // 更新类别统计
        String category = book.getCategory();
        categorySummary.put(category, categorySummary.getOrDefault(category, 0) + 1);

        System.out.println("Book added: " + book.getTitle());
    }

    @Override
    public void removeBook(String isbn) {
        Book bookToRemove = null;
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                bookToRemove = book;
                break;
            }
        }

        if (bookToRemove != null) {
            books.remove(bookToRemove);

            // 更新类别统计
            String category = bookToRemove.getCategory();
            categorySummary.put(category, categorySummary.get(category) - 1);

            System.out.println("Book removed: " + bookToRemove.getTitle());
        } else {
            System.out.println("Book not found with ISBN: " + isbn);
        }
    }

    @Override
    public Book searchBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public void displayAllBooks() {
        System.out.println("Library Catalog:");
        for (Book book : books) {
            System.out.println(book);
        }

        System.out.println("\nCategory Summary:");
        for (Map.Entry<String, Integer> entry : categorySummary.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " books");
        }
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user.getName());
    }

    public void removeUser(User user) {
        if (users.contains(user)) {
            users.remove(user);
            System.out.println("User removed: " + user.getName());
        } else {
            System.out.println("User not found!");
        }
    }

    public void borrowBook(User user, String isbn) {
        Book book = searchBook(isbn);
        if (book != null) {
            user.borrowBook(book);
        } else {
            System.out.println("Book not found with ISBN: " + isbn);
        }
    }

    public void returnBook(User user, String isbn) {
        Book book = searchBook(isbn);
        if (book != null) {
            user.returnBook(book);
        } else {
            System.out.println("Book not found with ISBN: " + isbn);
        }
    }

    @Override
    public void saveData() {
        try (ObjectOutputStream booksOut = new ObjectOutputStream(new FileOutputStream("books.dat"));
             ObjectOutputStream usersOut = new ObjectOutputStream(new FileOutputStream("users.dat"))) {

            booksOut.writeObject(books);
            usersOut.writeObject(users);

            System.out.println("Library data saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving library data: " + e.getMessage());
        }
    }

    @Override
    public void loadData() {
        try (ObjectInputStream booksIn = new ObjectInputStream(new FileInputStream("books.dat"));
             ObjectInputStream usersIn = new ObjectInputStream(new FileInputStream("users.dat"))) {

            books = (List<Book>) booksIn.readObject();
            users = (List<User>) usersIn.readObject();

            // 重新计算类别统计
            categorySummary.clear();
            for (Book book : books) {
                String category = book.getCategory();
                categorySummary.put(category, categorySummary.getOrDefault(category, 0) + 1);
            }

            System.out.println("Library data loaded successfully!");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading library data: " + e.getMessage());
        }
    }
}