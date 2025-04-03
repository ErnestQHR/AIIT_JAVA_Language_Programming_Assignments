import java.util.Scanner;

public class LibraryManagementSystem {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeData();

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getMenuChoice();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    displayAllBooks();
                    break;
                case 5:
                    borrowBook();
                    break;
                case 6:
                    returnBook();
                    break;
                case 7:
                    addUser();
                    break;
                case 8:
                    saveData();
                    break;
                case 9:
                    loadData();
                    break;
                case 0:
                    running = false;
                    System.out.println("Thank you for using the Library Management System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void initializeData() {
        // 添加一些图书和用户作为初始数据
        library.addBook(new Book("9781234567897", "Java Programming", "John Doe", "Programming"));
        library.addBook(new Book("9789876543210", "Data Structures", "Jane Smith", "Computer Science"));
        library.addBook(new Book("9780123456789", "Machine Learning", "Bob Johnson", "Artificial Intelligence"));

        User user1 = new User(1, "Alice", "alice@example.com");
        User user2 = new User(2, "Bob", "bob@example.com");

        library.addUser(user1);
        library.addUser(user2);

        Administrator admin = new Administrator(101, "Admin", "admin@library.com", 3);
    }

    private static void displayMenu() {
        System.out.println("\n=== Library Management System ===");
        System.out.println("1. Add a Book");
        System.out.println("2. Remove a Book");
        System.out.println("3. Search for a Book");
        System.out.println("4. Display All Books");
        System.out.println("5. Borrow a Book");
        System.out.println("6. Return a Book");
        System.out.println("7. Add a User");
        System.out.println("8. Save Data");
        System.out.println("9. Load Data");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getMenuChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // 无效选择
        }
    }

    private static void addBook() {
        System.out.println("\n=== Add a Book ===");

        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        System.out.print("Enter Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Author: ");
        String author = scanner.nextLine();

        System.out.print("Enter Category: ");
        String category = scanner.nextLine();

        Book book = new Book(isbn, title, author, category);
        library.addBook(book);
    }

    private static void removeBook() {
        System.out.println("\n=== Remove a Book ===");

        System.out.print("Enter ISBN of the book to remove: ");
        String isbn = scanner.nextLine();

        library.removeBook(isbn);
    }

    private static void searchBook() {
        System.out.println("\n=== Search for a Book ===");

        System.out.print("Enter ISBN to search: ");
        String isbn = scanner.nextLine();

        Book book = library.searchBook(isbn);
        if (book != null) {
            System.out.println("Book found: " + book);
        } else {
            System.out.println("Book not found with ISBN: " + isbn);
        }
    }

    private static void displayAllBooks() {
        library.displayAllBooks();
    }

    private static void borrowBook() {
        System.out.println("\n=== Borrow a Book ===");

        System.out.print("Enter User ID: ");
        int userId = Integer.parseInt(scanner.nextLine());

        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        System.out.print("Enter Book ISBN: ");
        String isbn = scanner.nextLine();

        library.borrowBook(user, isbn);
    }

    private static void returnBook() {
        System.out.println("\n=== Return a Book ===");

        System.out.print("Enter User ID: ");
        int userId = Integer.parseInt(scanner.nextLine());

        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        System.out.print("Enter Book ISBN: ");
        String isbn = scanner.nextLine();

        library.returnBook(user, isbn);
    }

    private static User findUserById(int id) {
        // 简化版，实际应该从library中获取用户列表
        if (id == 1) return new User(1, "Alice", "alice@example.com");
        if (id == 2) return new User(2, "Bob", "bob@example.com");
        return null;
    }

    private static void addUser() {
        System.out.println("\n=== Add a User ===");

        System.out.print("Enter User ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Contact: ");
        String contact = scanner.nextLine();

        User user = new User(id, name, contact);
        library.addUser(user);
    }

    private static void saveData() {
        library.saveData();
    }

    private static void loadData() {
        library.loadData();
    }
}