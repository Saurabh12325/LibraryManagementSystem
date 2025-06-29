import java.util.ArrayList;
import java.util.List;

public class LibraryManagement {


    static class Book {
        private String title;
        private String author;
        private boolean isIssued;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.isIssued = false;
        }

        public String getTitle()
        { return title;
        }
        public String getAuthor()
        { return author;
        }
        public boolean isIssued() {
            return isIssued;
        }

        public void issue() {
            this.isIssued = true;
        }
        public void returnBook() {
            this.isIssued = false;
        }
    }

    static class User {
        private String name;
        private List<Book> borrowedBooks = new ArrayList<>();

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void borrowBook(Book book) {
            borrowedBooks.add(book);
        }

        public void returnBook(Book book) {
            borrowedBooks.remove(book);
        }

        public List<Book> getBorrowedBooks() {
            return borrowedBooks;
        }
    }


    static class Library {
        private List<Book> books = new ArrayList<>();

        public void addBook(Book book) {
            books.add(book);
            System.out.println("Added book: " + book.getTitle());
        }

        public void issueBook(String title, User user) {
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(title) && !book.isIssued()) {
                    book.issue();
                    user.borrowBook(book);
                    System.out.println(user.getName() + " issued " + title);
                    return;
                }
            }
            System.out.println("Book not available or already issued.");
        }

        public void returnBook(String title, User user) {
            for (Book book : user.getBorrowedBooks()) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    book.returnBook();
                    user.returnBook(book);
                    System.out.println(user.getName() + " returned " + title);
                    return;
                }
            }
            System.out.println("This book was not borrowed by " + user.getName());
        }

        public void showBooks() {
            System.out.println("\nLibrary Books:");
            for (Book book : books) {
                System.out.println(book.getTitle() + " by " + book.getAuthor() +
                        " - " + (book.isIssued() ? "Issued" : "Available"));
            }
        }
    }

    // Main Method
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("Java Basics", "James Gosling"));
        library.addBook(new Book("Clean Code", "Robert Martin"));

        User user1 = new User("Alice");

        library.showBooks();
        library.issueBook("Java Basics", user1);
        library.showBooks();
        library.returnBook("Java Basics", user1);
        library.showBooks();
    }
}
