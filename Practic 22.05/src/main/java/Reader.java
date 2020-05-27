import java.util.ArrayList;

public class Reader {
    private String name;
    private String bilet;
    private String faculty;
    private String birthday;
    private String number;

    public Reader(String name, String bilet, String faculty, String birthday, String number) {
        this.name = name;
        this.bilet = bilet;
        this.faculty = faculty;
        this.birthday = birthday;
        this.number = number;
    }

    private ArrayList<Book> books = new ArrayList<Book>();

    public void takeBook(Book book)
    {
        books.add(book);
        System.out.println(name + " взял: " + book.name);
    }

    public void returnBook(Book book)
    {
        books.remove(book);
        System.out.println(name + " вернул: " + book.name);
    }

    public void takeBook(Book[] book)
    {
        String line = "";
        for(Book i : book) {
            books.add(i);
            line = line + i.name + " ";
        }
        System.out.println(name + " взял: " + line);
    }

    public void returnBook(Book[] book)
    {
        String line = "";
        for(Book i : book) {
            books.remove(i);
            line = line + i.name + " ";
        }
        System.out.println(name + " вернул: " + line);
    }

    public void takeBook(Book book, int count)
    {
        book.number = count;
        books.add(book);
        System.out.println(name + " взял "+ count +"шт: " + book.name);
    }

    public void returnBook(Book book, int count)
    {
        book.number = count;
        books.remove(book);
        System.out.println(name + " вернул "+ count +"шт: " + book.name);
    }
}
