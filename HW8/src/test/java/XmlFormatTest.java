import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class XmlFormatTest {
    static AbstractFormat af = FormatFactory.choose("xml");

    static Parent p1 = new Parent(1L, "Vasia", "Pupkin", "Ivanovich", 8, "Sunset blvrd apt 9");
    static Parent p2 = new Parent(2L, "Anton", "Shlyapkin", "Kazbekovich", 88, "Kazakova 22 apt 8");
    static Parent p3 = new Parent(3L, "Egor", "Kolbaskin", "Petrovich", 15, "Gagarina 15 apt 22");
    static Parent p4 = new Parent(4L, "Pavel", "Potolkov", "Pavlovich", 100, "Geroev Krut h 58");

    @Test
    void fromFormatTest() {
        String data = "<id>1</id>\n\r<firstName>Vasia</firstName>\n\r<lastName>Pupkin</lastName>\n\r<middleName>Ivanovich</middleName>\n\r<age>8</age>\n\r<address>Sunset blvrd apt 9</address>";
        Parent expected = p1;
        assert af != null;
        Parent actual = af.fromFormat(data);

        assertEquals(expected, actual);
    }

    @Test
    void toFormatTest() {
        assert af != null;
        String actual = af.toFormat(p1);
        String expected = "<id>1</id>\n\r<firstName>Vasia</firstName>\n\r<lastName>Pupkin</lastName>\n\r<middleName>Ivanovich</middleName>\n\r<age>8</age>\n\r<address>Sunset blvrd apt 9</address>";

        assertEquals(actual, expected);
    }

    @Test
    void fromFormatArrTest() {
        String[] data = {
                "<id>1</id>\n\r<firstName>Vasia</firstName>\n\r<lastName>Pupkin</lastName>\n\r<middleName>Ivanovich</middleName>\n\r<age>8</age>\n\r<address>Sunset blvrd apt 9</address>",
                "<id>2</id>\n\r<firstName>Anton</firstName>\n\r<lastName>Shlyapkin</lastName>\n\r<middleName>Kazbekovich</middleName>\n\r<age>88</age>\n\r<address>Kazakova 22 apt 8</address>",
                "<id>3</id>\n\r<firstName>Egor</firstName>\n\r<lastName>Kolbaskin</lastName>\n\r<middleName>Petrovich</middleName>\n\r<age>15</age>\n\r<address>Gagarina 15 apt 22</address>",
                "<id>4</id>\n\r<firstName>Pavel</firstName>\n\r<lastName>Potolkov</lastName>\n\r<middleName>Pavlovich</middleName>\n\r<age>100</age>\n\r<address>Geroev Krut h 58</address>"
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
                "<id>1</id>\n\r<firstName>Vasia</firstName>\n\r<lastName>Pupkin</lastName>\n\r<middleName>Ivanovich</middleName>\n\r<age>8</age>\n\r<address>Sunset blvrd apt 9</address>",
                "<id>2</id>\n\r<firstName>Anton</firstName>\n\r<lastName>Shlyapkin</lastName>\n\r<middleName>Kazbekovich</middleName>\n\r<age>88</age>\n\r<address>Kazakova 22 apt 8</address>",
                "<id>3</id>\n\r<firstName>Egor</firstName>\n\r<lastName>Kolbaskin</lastName>\n\r<middleName>Petrovich</middleName>\n\r<age>15</age>\n\r<address>Gagarina 15 apt 22</address>",
                "<id>4</id>\n\r<firstName>Pavel</firstName>\n\r<lastName>Potolkov</lastName>\n\r<middleName>Pavlovich</middleName>\n\r<age>100</age>\n\r<address>Geroev Krut h 58</address>"
        };

        assertArrayEquals(expected, actual);
    }

    @Test
    void toFormatStrTest() {
        String expected = "<id>1</id>\n\r<firstName>Vasia</firstName>\n\r<lastName>Pupkin</lastName>\n\r<middleName>Ivanovich</middleName>\n\r<age>8</age>\n\r<address>Sunset blvrd apt 9</address>-" +
                "<id>2</id>\n\r<firstName>Anton</firstName>\n\r<lastName>Shlyapkin</lastName>\n\r<middleName>Kazbekovich</middleName>\n\r<age>88</age>\n\r<address>Kazakova 22 apt 8</address>-" +
                "<id>3</id>\n\r<firstName>Egor</firstName>\n\r<lastName>Kolbaskin</lastName>\n\r<middleName>Petrovich</middleName>\n\r<age>15</age>\n\r<address>Gagarina 15 apt 22</address>-" +
                "<id>4</id>\n\r<firstName>Pavel</firstName>\n\r<lastName>Potolkov</lastName>\n\r<middleName>Pavlovich</middleName>\n\r<age>100</age>\n\r<address>Geroev Krut h 58</address>-";
        Parent[] data = {p1, p2, p3, p4};
        String actual = af.toFormatStr(data);

        assertEquals(expected, actual);
    }

    @Test
    void FromFormatStrTest() {
        String data = "<id>1</id>\n\r<firstName>Vasia</firstName>\n\r<lastName>Pupkin</lastName>\n\r<middleName>Ivanovich</middleName>\n\r<age>8</age>\n\r<address>Sunset blvrd apt 9</address>-" +
                "<id>2</id>\n\r<firstName>Anton</firstName>\n\r<lastName>Shlyapkin</lastName>\n\r<middleName>Kazbekovich</middleName>\n\r<age>88</age>\n\r<address>Kazakova 22 apt 8</address>-" +
                "<id>3</id>\n\r<firstName>Egor</firstName>\n\r<lastName>Kolbaskin</lastName>\n\r<middleName>Petrovich</middleName>\n\r<age>15</age>\n\r<address>Gagarina 15 apt 22</address>-" +
                "<id>4</id>\n\r<firstName>Pavel</firstName>\n\r<lastName>Potolkov</lastName>\n\r<middleName>Pavlovich</middleName>\n\r<age>100</age>\n\r<address>Geroev Krut h 58</address>-";
        Parent[] expected = {p1, p2, p3, p4};
        Parent[] actual = af.fromFormatStr(data);

        assertArrayEquals(expected, actual);
    }
}