// Abstract class LibraryMember
abstract class LibraryMember {
    private String name;      // encapsulated
    private int borrowedBooks; // number of books currently borrowed
    private int borrowLimit;   // maximum books allowed

    public LibraryMember(String name, int borrowLimit) throws Exception {
        if (name == null || name.trim().isEmpty()) {
            throw new Exception("Name cannot be empty!");
        }
        if (borrowLimit <= 0) {
            throw new Exception("Borrow limit must be positive!");
        }
        this.name = name;
        this.borrowLimit = borrowLimit;
        this.borrowedBooks = 0;
    }

    public String getName() {
        return name;
    }

    public int getBorrowedBooks() {
        return borrowedBooks;
    }

    protected void increaseBorrowedBooks() throws Exception {
        if (borrowedBooks >= borrowLimit) {
            throw new Exception(getName() + " has reached borrowing limit of " + borrowLimit);
        }
        borrowedBooks++;
    }

    // Abstract method to borrow a book
    public abstract void borrowBook() throws Exception;
}

// Subclass Student
class Student extends LibraryMember {
    public Student(String name) throws Exception {
        super(name, 3); // students can borrow up to 3 books
    }

    @Override
    public void borrowBook() throws Exception {
        increaseBorrowedBooks();
        System.out.println(getName() + " (Student) borrowed a book. Total borrowed: " + getBorrowedBooks());
    }
}

// Subclass Teacher
class Teacher extends LibraryMember {
    public Teacher(String name) throws Exception {
        super(name, 5); // teachers can borrow up to 5 books
    }

    @Override
    public void borrowBook() throws Exception {
        increaseBorrowedBooks();
        System.out.println(getName() + " (Teacher) borrowed a book. Total borrowed: " + getBorrowedBooks());
    }
}

// Subclass Guest
class Guest extends LibraryMember {
    public Guest(String name) throws Exception {
        super(name, 1); // guests can borrow only 1 book
    }

    @Override
    public void borrowBook() throws Exception {
        increaseBorrowedBooks();
        System.out.println(getName() + " (Guest) borrowed a book. Total borrowed: " + getBorrowedBooks());
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        try {
            LibraryMember[] members = {
                    new Student("Alice"),
                    new Teacher("Bob"),
                    new Guest("Charlie")
            };

            // Polymorphic borrowing
            members[0].borrowBook();
            members[0].borrowBook();
            members[0].borrowBook();
            // This will throw exception: Student exceeds limit
            members[0].borrowBook();

            members[1].borrowBook();
            members[2].borrowBook();
            // This will throw exception: Guest exceeds limit
            members[2].borrowBook();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
