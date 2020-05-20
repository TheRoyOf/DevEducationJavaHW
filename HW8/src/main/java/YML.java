import Person.Person;

public class YML extends AbstractFormat {
    public String toFormat(Person data) {
        return "id: "+data.id+"\nname: "+data.name+"\nsurname: "+data.surname+"\nage: "+data.age+"";
    }
}
