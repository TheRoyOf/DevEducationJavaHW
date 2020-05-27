import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        Reader reader = new Reader("Петров В. В.", "","","","");

        Book bookAdventure = new Book("Приключения");
        Book bookHistory = new Book("История");
        Book bookXXX = new Book("Камасутра");

        Book[] books = {bookAdventure,bookHistory,bookXXX};

        reader.takeBook(bookAdventure);
        reader.returnBook(bookAdventure);
        reader.takeBook(bookAdventure, 3);
        reader.returnBook(bookAdventure, 3);
        reader.takeBook(books);
        reader.returnBook(books);
    }
}
