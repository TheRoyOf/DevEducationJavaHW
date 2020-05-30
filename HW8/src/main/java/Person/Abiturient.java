package Person;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Abiturient extends Person{

    String phoneNumber;     // переменная нигде не используется
    Map<String,Float> assesment = new HashMap<String, Float>(); // можно просто new HashMap<>(); компилятор поймет такую запись

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
