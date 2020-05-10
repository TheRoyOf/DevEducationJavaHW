import static org.junit.jupiter.api.Assertions.*;

class JsonTest {

    @org.junit.jupiter.api.Test
    void toFormat() {
        Person p = new Person(12L, "Ivan", "Ivanov", 21);
        String expected = "{\"id\": 12, \"name\": \"Ivan\", \"surname\": \"Ivanov\", \"age\": 21}";
        assertEquals(expected,new Json().toFormat(p));
    }
}