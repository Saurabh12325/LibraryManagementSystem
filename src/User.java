import java.util.List;

public class User {
    private String name;
    private List<Book> borrowedBooks;

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void BorrowBook(Book book){
        borrowedBooks.add(book);
    }
    public void returnBook(Book book){
        borrowedBooks.remove(book);
    }
}
