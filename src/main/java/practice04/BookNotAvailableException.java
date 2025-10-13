package practice04;

import java.io.*;
import java.util.*;

// Custom Exception for unavailable books
class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

// Book class
class Book implements Serializable {
    private String id;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }

    public void issue() { this.isIssued = true; }
    public void returnBook() { this.isIssued = false; }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s", id, title, author, (isIssued ? "Issued" : "Available"));
    }
}

// Member class
class Member implements Serializable {
    private String memberId;
    private String name;
    private List<String> borrowedBooks = new ArrayList<>();

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }

    public void borrowBook(String bookId) {
        borrowedBooks.add(bookId);
    }

    public void returnBook(String bookId) {
        borrowedBooks.remove(bookId);
    }

    @Override
    public String toString() {
        return String.format("%s | %s | Borrowed: %s", memberId, name, borrowedBooks);
    }
}

// Library class
class Library implements Serializable {
    private Map<String, Book> books = new HashMap<>();
    private Map<String, Member> members = new HashMap<>();

    // Add a new book
    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    // Add a new member
    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
    }

    // Issue a book
    public void issueBook(String bookId, String memberId) throws BookNotAvailableException {
        Book book = books.get(bookId);
        Member member = members.get(memberId);

        if (book == null || member == null) {
            throw new IllegalArgumentException("Invalid Book ID or Member ID.");
        }

        if (book.isIssued()) {
            throw new BookNotAvailableException("Book is already issued!");
        }

        book.issue();
        member.borrowBook(bookId);
    }

    // Return a book
    public void returnBook(String bookId, String memberId) {
        Book book = books.get(bookId);
        Member member = members.get(memberId);

        if (book != null && member != null) {
            book.returnBook();
            member.returnBook(bookId);
        }
    }

    // Display all books
    public void showAllBooks() {
        books.values().forEach(System.out::println);
    }

    // Display available books
    public void showAvailableBooks() {
        books.values().stream()
                .filter(b -> !b.isIssued())
                .forEach(System.out::println);
    }

    // Save data to file
    public void saveLibraryData() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("library.dat"))) {
            oos.writeObject(this);
        }
    }

    // Load data from file
    public static Library loadLibraryData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("library.dat"))) {
            return (Library) ois.readObject();
        } catch (Exception e) {
            return new Library(); // return new if no data
        }
    }
}

