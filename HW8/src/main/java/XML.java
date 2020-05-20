import Person.Person;

public class XML extends AbstractFormat {
    public String toFormat(Person data) {
        return "<id>"+data.id+"</id> \n<name>"+data.name+"</name>\n<surname>"+data.surname+"<surname>\n<age>"+data.age+"</age>";
    }
}
