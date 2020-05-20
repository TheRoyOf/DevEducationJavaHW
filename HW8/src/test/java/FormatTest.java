import Person.Person;

import static org.junit.jupiter.api.Assertions.*;

class FormatTest {

    @org.junit.jupiter.api.Test
    void TEST_JSON_toFormat() {
        Person p = new Person(12L, "Ivan", "Ivanov","Ivanovich","mystreet 421",21);
        String expected = "{\"id\": 12, \"name\": \"Ivan\", \"surname\": \"Ivanov\", \"age\": 21}";
        assertEquals(expected,new Json().toFormat(p));
    }
}