public class LibrarySystem {
    private Book[] books;
    private int bookCount;

    public LibrarySystem(int capacity) {
        books = new Book[capacity];
        bookCount = 0;
    }

    public void addBook(User user, Book newBook) {
        if (user.hasPermission("add")) {
            if (bookCount < books.length) {
                books[bookCount++] = newBook;
            } else {
                System.out.println("Library is full, cannot add more books.");
            }
        } else {
            System.out.println("Permission denied: Cannot add books.");
        }
    }

    public void removeBook(User user, String title) {
        if (user.hasPermission("remove")) {
            for (int i = 0; i < bookCount; i++) {
                if (books[i].getTitle().equals(title)) {
                    books[i] = books[--bookCount];
                    books[bookCount] = null;
                    return;
                }
            }
            System.out.println("Book not found.");
        } else {
            System.out.println("Permission denied: Cannot remove books.");
        }
    }

    public Book searchBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equals(title)) {
                return books[i];
            }
        }
        return null;
    }

    public void displayAvailableBooks() {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].isAvailable()) {
                System.out.println("Title: " + books[i].getTitle() + ", Author: " + books[i].getAuthor());
            }
        }
    }

    public void borrowBook(User user, String title) {
        if (user.hasPermission("borrow")) {
            Book book = searchBook(title);
            if (book != null && book.isAvailable()) {
                book.setAvailable(false);
                System.out.println("Book borrowed: " + title);
            } else {
                System.out.println("Book is not available.");
            }
        } else {
            System.out.println("Permission denied: Cannot borrow books.");
        }
    }

    public void returnBook(User user, String title) {
        if (user.hasPermission("return")) {
            Book book = searchBook(title);
            if (book != null && !book.isAvailable()) {
                book.setAvailable(true);
                System.out.println("Book returned: " + title);
            } else {
                System.out.println("Book was not borrowed.");
            }
        } else {
            System.out.println("Permission denied: Cannot return books.");
        }
    }
}
