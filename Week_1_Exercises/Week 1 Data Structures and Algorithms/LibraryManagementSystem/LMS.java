public class LMS {
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem(10);

        library.addBook(new Book(1, "A Tale of Two Cities", "Charles Dickens"));
        library.addBook(new Book(2, "Brave New World", "Aldous Huxley"));
        library.addBook(new Book(3, "Catching Fire", "Suzanne Collins"));
        library.addBook(new Book(4, "Dune", "Frank Herbert"));
        library.addBook(new Book(5, "Ender's Game", "Orson Scott Card"));

        System.out.println("All books in the library:");
        library.printBooks();

        System.out.println("\nSearching for 'Dune' using linear search:");
        Book foundBook = library.linearSearchByTitle("Dune");
        if (foundBook != null) {
            System.out.println("Found: " + foundBook);
        } else {
            System.out.println("Book not found.");
        }

        System.out.println("\nSearching for 'Brave New World' using binary search:");
        Book foundBook2 = library.binarySearchByTitle("Brave New World");
        if (foundBook2 != null) {
            System.out.println("Found: " + foundBook2);
        } else {
            System.out.println("Book not found.");
        }
    }
}
