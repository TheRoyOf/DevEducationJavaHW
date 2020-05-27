import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonFormatTest {
    static AbstractFormat af = FormatFactory.choose("json");

    static Parent p1 = new Parent(1L, "Vasia", "Pupkin", "Ivanovich", 8, "Sunset blvrd apt 9");
    static Parent p2 = new Parent(2L, "Anton", "Shlyapkin", "Kazbekovich", 88, "Kazakova 22 apt 8");
    static Parent p3 = new Parent(3L, "Egor", "Kolbaskin", "Petrovich", 15, "Gagarina 15 apt 22");
    static Parent p4 = new Parent(4L, "Pavel", "Potolkov", "Pavlovich", 100, "Geroev Krut h 58");

    @Test
    void fromFormatArrTest() {
        String[] data = {
                "{\"Id\" : \"1\", \"firstName\" : \"Vasia\", \"lastName\" : \"Pupkin\", \"middleName\" : \"Ivanovich\", \"Age\" : \"8\", \"Address\" : \"Sunset blvrd apt 9\"}",
                "{\"Id\" : \"2\", \"firstName\" : \"Anton\", \"lastName\" : \"Shlyapkin\", \"middleName\" : \"Kazbekovich\", \"Age\" : \"88\", \"Address\" : \"Kazakova 22 apt 8\"}",
                "{\"Id\" : \"3\", \"firstName\" : \"Egor\", \"lastName\" : \"Kolbaskin\", \"middleName\" : \"Petrovich\", \"Age\" : \"15\", \"Address\" : \"Gagarina 15 apt 22\"}",
                "{\"Id\" : \"4\", \"firstName\" : \"Pavel\", \"lastName\" : \"Potolkov\", \"middleName\" : \"Pavlovich\", \"Age\" : \"100\", \"Address\" : \"Geroev Krut h 58\"}"
        };
        Parent[] expected = {p1, p2, p3, p4};
        assert af != null;
        Parent[] actual = {af.fromFormat(data[0]), af.fromFormat(data[1]), af.fromFormat(data[2]), af.fromFormat(data[3])};

        assertArrayEquals(expected, actual);
    }

    @Test
    void toFormatArrTest() {
        assert af != null;
        String[] actual = {af.toFormat(p1), af.toFormat(p2), af.toFormat(p3), af.toFormat(p4)};
        String[] expected = {
                "{\"Id\" : \"1\", \"firstName\" : \"Vasia\", \"lastName\" : \"Pupkin\", \"middleName\" : \"Ivanovich\", \"Age\" : \"8\", \"Address\" : \"Sunset blvrd apt 9\"}",
                "{\"Id\" : \"2\", \"firstName\" : \"Anton\", \"lastName\" : \"Shlyapkin\", \"middleName\" : \"Kazbekovich\", \"Age\" : \"88\", \"Address\" : \"Kazakova 22 apt 8\"}",
                "{\"Id\" : \"3\", \"firstName\" : \"Egor\", \"lastName\" : \"Kolbaskin\", \"middleName\" : \"Petrovich\", \"Age\" : \"15\", \"Address\" : \"Gagarina 15 apt 22\"}",
                "{\"Id\" : \"4\", \"firstName\" : \"Pavel\", \"lastName\" : \"Potolkov\", \"middleName\" : \"Pavlovich\", \"Age\" : \"100\", \"Address\" : \"Geroev Krut h 58\"}"
        };

        assertArrayEquals(expected, actual);
    }

    @Test
    void fromFormatTest() {
        String data = "{\"Id\" : \"1\", \"firstName\" : \"Vasia\", \"lastName\" : \"Pupkin\", \"middleName\" : \"Ivanovich\", \"Age\" : \"8\", \"Address\" : \"Sunset blvrd apt 9\"}";
        Parent expected = new Parent(1L, "Vasia", "Pupkin", "Ivanovich", 8, "Sunset blvrd apt 9");
        assert af != null;
        Parent actual = af.fromFormat(data);

        assertEquals(expected, actual);
    }

    @Test
    void toFormatTest() {
        String expected = "{\"Id\" : \"1\", \"firstName\" : \"Vasia\", \"lastName\" : \"Pupkin\", \"middleName\" : \"Ivanovich\", \"Age\" : \"32\", \"Address\" : \"Sunset blvrd apt 9\"}";
        Parent p = new Parent(1L, "Vasia", "Pupkin", "Ivanovich", 32, "Sunset blvrd apt 9");
        assert af != null;
        String actual = af.toFormat(p);

        assertEquals(expected, actual);
    }

    @Test
    void toFormatStrTest() {
        String expected = "{\"Id\" : \"1\", \"firstName\" : \"Vasia\", \"lastName\" : \"Pupkin\", \"middleName\" : \"Ivanovich\", \"Age\" : \"8\", \"Address\" : \"Sunset blvrd apt 9\"}-" +
                "{\"Id\" : \"2\", \"firstName\" : \"Anton\", \"lastName\" : \"Shlyapkin\", \"middleName\" : \"Kazbekovich\", \"Age\" : \"88\", \"Address\" : \"Kazakova 22 apt 8\"}-" +
                "{\"Id\" : \"3\", \"firstName\" : \"Egor\", \"lastName\" : \"Kolbaskin\", \"middleName\" : \"Petrovich\", \"Age\" : \"15\", \"Address\" : \"Gagarina 15 apt 22\"}-" +
                "{\"Id\" : \"4\", \"firstName\" : \"Pavel\", \"lastName\" : \"Potolkov\", \"middleName\" : \"Pavlovich\", \"Age\" : \"100\", \"Address\" : \"Geroev Krut h 58\"}-";
        Parent[] data = {p1, p2, p3, p4};
        String actual = af.toFormatStr(data);

        assertEquals(expected, actual);
    }

    @Test
    void FromFormatStrTest() {
        String data = "{\"Id\" : \"1\", \"firstName\" : \"Vasia\", \"lastName\" : \"Pupkin\", \"middleName\" : \"Ivanovich\", \"Age\" : \"8\", \"Address\" : \"Sunset blvrd apt 9\"}-" +
                "{\"Id\" : \"2\", \"firstName\" : \"Anton\", \"lastName\" : \"Shlyapkin\", \"middleName\" : \"Kazbekovich\", \"Age\" : \"88\", \"Address\" : \"Kazakova 22 apt 8\"}-" +
                "{\"Id\" : \"3\", \"firstName\" : \"Egor\", \"lastName\" : \"Kolbaskin\", \"middleName\" : \"Petrovich\", \"Age\" : \"15\", \"Address\" : \"Gagarina 15 apt 22\"}-" +
                "{\"Id\" : \"4\", \"firstName\" : \"Pavel\", \"lastName\" : \"Potolkov\", \"middleName\" : \"Pavlovich\", \"Age\" : \"100\", \"Address\" : \"Geroev Krut h 58\"}-";
        Parent[] expected = {p1, p2, p3, p4};
        Parent[] actual = af.fromFormatStr(data);

        assertArrayEquals(expected, actual);
    }
}