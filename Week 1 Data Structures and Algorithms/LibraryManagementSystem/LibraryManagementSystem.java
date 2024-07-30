public class LibraryManagementSystem {
    private Book[] books;
    private int size;

    public LibraryManagementSystem(int capacity) {
        books = new Book[capacity];
        size = 0;
    }

    // Add a new book to the array
    public void addBook(Book book) {
        if (size < books.length) {
            books[size] = book;
            size++;
        } else {
            System.out.println("Library is full.");
        }
    }

    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    public Book binarySearchByTitle(String title){
        int left=0;
        int right=size-1;

        while(left<=right){
            int mid=left+(right-left)/2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);

            if(comparison==0){
                return books[mid];
            }
            else if(comparison<0){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return null;
    }

    public void printBooks(){
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }
    
}