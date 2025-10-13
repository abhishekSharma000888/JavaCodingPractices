package practice04;

import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = Library.loadLibraryData();

        while (true) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Show All Books");
            System.out.println("6. Show Available Books");
            System.out.println("7. Save & Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Book ID: ");
                        String id = sc.nextLine();
                        System.out.print("Enter Title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter Author: ");
                        String author = sc.nextLine();
                        library.addBook(new Book(id, title, author));
                        System.out.println("Book added successfully!");
                        break;

                    case 2:
                        System.out.print("Enter Member ID: ");
                        String memberId = sc.nextLine();
                        System.out.print("Enter Member Name: ");
                        String name = sc.nextLine();
                        library.addMember(new Member(memberId, name));
                        System.out.println("Member added successfully!");
                        break;

                    case 3:
                        System.out.print("Enter Book ID to issue: ");
                        String bookId = sc.nextLine();
                        System.out.print("Enter Member ID: ");
                        String memId = sc.nextLine();
                        library.issueBook(bookId, memId);
                        System.out.println("Book issued successfully!");
                        break;

                    case 4:
                        System.out.print("Enter Book ID to return: ");
                        String returnBookId = sc.nextLine();
                        System.out.print("Enter Member ID: ");
                        String returnMemId = sc.nextLine();
                        library.returnBook(returnBookId, returnMemId);
                        System.out.println("Book returned successfully!");
                        break;

                    case 5:
                        System.out.println("\nAll Books:");
                        library.showAllBooks();
                        break;

                    case 6:
                        System.out.println("\nAvailable Books:");
                        library.showAvailableBooks();
                        break;

                    case 7:
                        library.saveLibraryData();
                        System.out.println("Data saved. Exiting...");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid option. Try again!");
                }
            } catch (BookNotAvailableException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }
}