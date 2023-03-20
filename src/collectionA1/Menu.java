package collectionA1;

import java.util.Scanner;

public class Menu {
    Scanner scan = new Scanner(System.in);
    Library library = new Library();
        public Menu(){
            start();

        }




    public void displayMenu() {

        System.out.println("1: Add a user");
        System.out.println("2: Delete a user");
        System.out.println("3: Add a book in the user list ");
        System.out.println("4: Remove book from the user list ");
        System.out.println("5: Add a book in library database ");
        System.out.println("6: Remove a book from the library database ");
        System.out.println("7: Exit ");

    }

    public void start() {

        while (true) {
            displayMenu();

            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    deleteUser();
                    break;
                case 3:
                    addBookToLibrary();
                    break;
                case 4:
                    removeBookFromLibrary();
                    break;
                case 5:
                    addBookToUserReadingList();
                    break;
                case 6:
                    removeBookToUserReadingList();
                    break;
                case 7:
                    System.exit(0);
                     break;
                default:
                    System.out.println("Invalid input");


            }
        }


    }

    private void addUser() {
        System.out.println("Enter the name");
        String name = scan.next();
        User user = new User(name);
        library.addUser(user);


    }

    private void deleteUser() {
        System.out.println("Enter the user name");
        String name = scan.next();
        User user = new User(name);
        library.removeUser(user);


    }

    public void addBookToLibrary() {

        System.out.println("Enter the book title ");
        String title = scan.next();
        System.out.println("Enter the author name ");
        String authorName = scan.next();

        System.out.println("Enter the isbn number ");
        int isbn = scan.nextInt();
        Author author = new Author(authorName);
        Book book = new Book(title, author, isbn);
        library.addBook(book);
    }

    public void removeBookFromLibrary() {


        System.out.println("Enter the isbn number ");
        int isbn = scan.nextInt();
        library.removeBook(isbn);

    }

    public void addBookToUserReadingList() {


        System.out.println("Enter the user name ");
        String userName = scan.next();
        System.out.println("Enter the isbn number ");
        int isbn = scan.nextInt();
       if (library.findABook(isbn)==null){
           System.out.println("Cannot find the book");
           return;
       }
       Book book=  library.findABook(isbn);

        User user = new User(userName);

        library.addBookToReadingList(user, book);

    }


    public void removeBookToUserReadingList() {


        System.out.println("Enter the user name ");
        String userName = scan.next();
        System.out.println("Enter the isbn number ");
        int isbn = scan.nextInt();
        if (library.findABook(isbn)==null){
            System.out.println("Cannot find the book");
            return;
        }
        Book book=  library.findABook(isbn);

        User user = new User(userName);

        library.removeBookFromReadingList(user, book);

    }

}