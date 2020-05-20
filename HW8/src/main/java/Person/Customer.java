package Person;

public class Customer extends Person {

    public String cardNumber;
    public String bankNumber;
    public String phoneNumber;

    public Customer(long id, String name, String surname, String patronymic, String address, int age,
                    String cardNumber, String bankNumber, String phoneNumber) {

        super(id, name, surname, patronymic, address, age);

        this.cardNumber = cardNumber;
        this.bankNumber = bankNumber;
        this.phoneNumber = phoneNumber;

    }
}
