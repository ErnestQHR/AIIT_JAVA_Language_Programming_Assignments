public interface ILibraryOperations {
    void addBook(Book book);
    void removeBook(String isbn);
    Book searchBook(String isbn);
    void displayAllBooks();
    void saveData();
    void loadData();
}