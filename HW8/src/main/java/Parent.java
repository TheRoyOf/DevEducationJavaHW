import java.util.Objects;

public class Parent {
    long id;
    String firstName;
    String lastName;
    String middleName;
    int age;
    String address;

    public Parent(long id, String firstName, String lastName, String middleName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public Parent(long id, String firstName, String lastName, String middleName, int age) {
        this(id, firstName, lastName, middleName);
        this.age = age;
    }

    public Parent(long id, String firstName, String lastName, String middleName, int age, String address) {
        this(id, firstName, lastName, middleName, age);
        this.address = address;
    }

    public Parent(long id, String firstName, String lastName, String middleName, String address) {
        this(id, firstName, lastName, middleName);
        this.address = address;
    }

    public Parent() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Parent)) return false;
        Parent parent = (Parent) o;
        return getId() == parent.getId() &&
                getAge() == parent.getAge() &&
                getFirstName().equals(parent.getFirstName()) &&
                getLastName().equals(parent.getLastName()) &&
                getMiddleName().equals(parent.getMiddleName()) &&
                getAddress().equals(parent.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getMiddleName(), getAge(), getAddress());
    }

    public Parent(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.middleName = builder.middleName;
        this.address = builder.address;
        this.age = builder.age;
    }

    public static class Builder {
        private long id;
        private String firstName;
        private String lastName;
        private String middleName;
        private int age;
        private String address;

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Parent build() {
            return new Parent(this);
        }
    }

    public void show() {
        System.out.println("id: " + this.id);
        System.out.println("firstName: " + this.firstName);
        System.out.println("lastName: " + this.lastName);
        System.out.println("middleName: " + this.middleName);
        System.out.println("age: " + this.age);
        System.out.println("address: " + this.address);
    }

    public Parent fetchParent() {
        return null;
    }
}
