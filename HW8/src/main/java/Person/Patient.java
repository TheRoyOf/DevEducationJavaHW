package Person;

public class Patient extends Person{

    public String medicCardNumber;
    public String diagnosis;

    public Patient(long id, String name, String surname, String patronymic, String address, int age, String medicCardNumber, String diagnosis) {
        super(id, name, surname, patronymic, address, age);

        this.medicCardNumber = medicCardNumber;
        this.diagnosis = diagnosis;
    }
}
