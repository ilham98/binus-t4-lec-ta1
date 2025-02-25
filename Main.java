public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem(10);

        Admin admin = new Admin("Admin1", "A001");
        Member member = new Member("Member1", "M001");

        Book book1 = new Book("Java Programming", "Author1");
        Book book2 = new Book("Data Structures", "Author2");

        library.addBook(book1);
        library.addBook(book2);

        System.out.println("Available books:");
        library.displayAvailableBooks();

        library.borrowBook("Java Programming");
        System.out.println("Available books after borrowing:");
        library.displayAvailableBooks();

        library.returnBook("Java Programming");
        System.out.println("Available books after returning:");
        library.displayAvailableBooks();
    }
}
