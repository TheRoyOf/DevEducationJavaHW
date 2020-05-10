public class Json extends AbstractType {
    public String toFormat(Person data) {
        return "{\"id\": "+data.id+", \"name\": \""+data.name+"\", \"surname\": \""+data.surname+"\", \"age\": "+data.age+"}";
    }
}
