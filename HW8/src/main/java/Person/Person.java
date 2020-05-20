package Person;

import java.sql.Timestamp;

public class Person {

    public long id;
    public String name;
    public String surname;
    public String patronymic;
    public String address;
    public int age;

    public Person(long id, String name, String surname, String patronymic, String address, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.address = address;
        this.age = age;
    }
}
