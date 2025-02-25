import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem(10);

        Admin admin = new Admin("Admin1", "A001");
        Member member = new Member("Member1", "M001");

        Book book1 = new Book("Java Programming", "Author1");
        Book book2 = new Book("Data Structures", "Author2");

        library.addBook(admin, book1);
        library.addBook(admin, book2);

        Scanner scanner = new Scanner(System.in);
        User user = null;

        boolean exit = false;
        while (!exit) {
            System.out.println("Enter username (Admin1 or Member1) or type 'exit' to quit:");
            String username = scanner.nextLine();

            if (username.equalsIgnoreCase("exit")) {
                exit = true;
                continue;
            } else if (username.equalsIgnoreCase(admin.getName())) {
                user = admin;
            } else if (username.equalsIgnoreCase(member.getName())) {
                user = member;
            } else {
                System.out.println("Invalid username.");
                continue;
            }

            boolean userExit = false;
            while (!userExit) {
                System.out.println("Choose an action:");
                if (user instanceof Admin) {
                    System.out.println("1. Add Book");
                    System.out.println("2. Remove Book");
                }
                System.out.println("3. Borrow Book");
                System.out.println("4. Return Book");
                System.out.println("5. Display Available Books");
                System.out.println("6. Change User");
                System.out.println("7. Exit");

                int action = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (action) {
                    case 1:
                        if (user instanceof Admin) {
                            System.out.println("Enter book title:");
                            String title = scanner.nextLine();
                            System.out.println("Enter book author:");
                            String author = scanner.nextLine();
                            library.addBook(user, new Book(title, author));
                        } else {
                            System.out.println("Invalid action.");
                        }
                        break;
                    case 2:
                        if (user instanceof Admin) {
                            System.out.println("Enter book title to remove:");
                            String title = scanner.nextLine();
                            library.removeBook(user, title);
                        } else {
                            System.out.println("Invalid action.");
                        }
                        break;
                    case 3:
                        System.out.println("Enter book title to borrow:");
                        String borrowTitle = scanner.nextLine();
                        library.borrowBook(user, borrowTitle);
                        break;
                    case 4:
                        System.out.println("Enter book title to return:");
                        String returnTitle = scanner.nextLine();
                        library.returnBook(user, returnTitle);
                        break;
                    case 5:
                        library.displayAvailableBooks();
                        break;
                    case 6:
                        userExit = true;
                        break;
                    case 7:
                        userExit = true;
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid action.");
                }
            }
        }

        scanner.close();
    }
}
