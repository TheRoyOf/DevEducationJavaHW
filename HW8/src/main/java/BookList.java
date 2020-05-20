import java.util.ArrayList;

public class BookList {
    static ArrayList<Book> books = new ArrayList<Book>();


    public static ArrayList<Book> GetByAutor(String autor)
    {
        ArrayList<Book> rezult = new ArrayList<Book>();

        for (Book book:books)
        {
            for (String item:book.autors)
            {
                if (item.equals(autor))
                {
                    rezult.add(book);
                    break;
                }
            }
        }
        return rezult;
    }

    public static ArrayList<Book> GetByPublisher(String publisher)
    {
        ArrayList<Book> rezult = new ArrayList<Book>();

        for (Book book:books)
        {
            if (book.publisher.equals(publisher))
            {
                rezult.add(book);
            }
        }
        return rezult;
    }

    public static ArrayList<Book> AfterYear(int year)
    {
        ArrayList<Book> rezult = new ArrayList<Book>();

        for (Book book:books)
        {
            if (book.year>=year)
            {
                rezult.add(book);
            }
        }
        return rezult;
    }
}
