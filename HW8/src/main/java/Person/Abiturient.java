package Person;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Abiturient extends Person{

    String phoneNumber;
    Map<String,Float> assesment = new HashMap<String, Float>();

    public Abiturient(long id, String name, String surname, String patronymic, String address, int age) {
        super(id, name, surname, patronymic, address, age);
    }

    public void AddAssesment(String subject, float val)
    {
        assesment.put(subject,val);
    }

    public float GetRating(String subject)
    {
        return assesment.get(subject);
    }

    public Set<String> GetAssesment()
    {
        return assesment.keySet();
    }
}
