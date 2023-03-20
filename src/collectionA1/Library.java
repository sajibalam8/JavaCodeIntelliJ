package collectionA1;

import java.util.*;

public class Library {

    private List<Book> listOfBooks;
    private Set<Author> listOfAuthors;

    private Map<User, List<Book>> readingLists;


    public Library(){

        listOfBooks= new ArrayList<>();
        listOfAuthors= new HashSet<>();
        readingLists= new HashMap<>();

    }


    public void addBook(Book book) {

        listOfBooks.add(book);
    }

    public void removeBook(int isbn) {

        for (Book b : listOfBooks) {

            if (b.getIsbn() == isbn) {
                listOfBooks.remove(b);
                return;

            }
        }


    }


    public void addAuthor(Author author) {

        listOfAuthors.add(author);
    }

    public void removeAuthor(Author author) {

        listOfAuthors.remove(author);
    }


    public void addBookToReadingList(User user, Book book) {

        if (readingLists.get(user) == null) {

            List<Book> newList = new ArrayList();
            newList.add(book);
            readingLists.put(user, newList);

        } else {
            List<Book> list = readingLists.get(user);
            list.add(book);
            readingLists.put(user, list);


        }

    }

    public boolean removeBookFromReadingList(User user, Book book) {

        if (readingLists.get(user) == null) {
            System.out.println("The following " + user + "do not exist");
            return false;

        } else {
            List<Book> list = readingLists.get(user);
            list.remove(book);
            readingLists.put(user, list);
            System.out.println("The following " + user + "do not exist");
            return true;


        }

    }

    public void addUser(User user) {
        readingLists.put(user, null);


    }

    public void removeUser(User user) {
        readingLists.remove(user);


    }

    public Book findABook(int isbn) {

        for (Book b : listOfBooks)
            if (b.getIsbn() == isbn) {

                return b;

            }

        return null;
    }
}
