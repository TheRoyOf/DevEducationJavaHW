public class Phone implements Comparable<Phone> {
    public long id;
    public String name;
    public String surname;
    public String patronymic;
    public String address;
    public String cardNumber;
    float debit;
    float credit;
    long speckTime;

    public int compareTo(Phone other) {
        return (int) (this.id-other.id);
    }
}
