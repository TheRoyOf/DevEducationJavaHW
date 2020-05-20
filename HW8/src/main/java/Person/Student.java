package Person;

public class Student extends Person{

    public String number;
    public String faculty;
    public int course;
    public String group;
    String birthday;


    public Student(long id, String name, String surname, String patronymic, String address, String birthday,
                   String number, String faculty, int course, String group) {

        super(id, name, surname, patronymic, address, Integer.parseInt(birthday.split("\\.")[2]));
        this.number = number;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

}
