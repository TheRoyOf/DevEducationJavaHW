import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class YmlFormatTest {
    static AbstractFormat af = FormatFactory.choose("yml");

    static Parent p1 = new Parent(1L, "Vasia", "Pupkin", "Ivanovich", 8, "Sunset blvrd apt 9");
    static Parent p2 = new Parent(2L, "Anton", "Shlyapkin", "Kazbekovich", 88, "Kazakova 22 apt 8");
    static Parent p3 = new Parent(3L, "Egor", "Kolbaskin", "Petrovich", 15, "Gagarina 15 apt 22");
    static Parent p4 = new Parent(4L, "Pavel", "Potolkov", "Pavlovich", 100, "Geroev Krut h 58");

    @Test
    void fromFormatTest() {
        String data = "\tid: 1\n\r" + "\tfirstName: Vasia\n\r" + "\tlastName: Pupkin\n\r" + "\tmiddleName: Ivanovich\n\r" + "\tage: 8\n\r" + "\taddress: Sunset blvrd apt 9";
        Parent expected = p1;
        assert af != null;
        Parent actual = af.fromFormat(data);

        assertEquals(expected, actual);
    }

    @Test
    void toFormatTest() {
        assert af != null;
        String actual = af.toFormat(p1);
        String expected = "\tid: 1\n\r" + "\tfirstName: Vasia\n\r" + "\tlastName: Pupkin\n\r" + "\tmiddleName: Ivanovich\n\r" + "\tage: 8\n\r" + "\taddress: Sunset blvrd apt 9";

        assertEquals(actual, expected);
    }

    @Test
    void fromFormatArrTest() {
        String[] data = {
                "\tid: 1\n\r" + "\tfirstName: Vasia\n\r" + "\tlastName: Pupkin\n\r" + "\tmiddleName: Ivanovich\n\r" + "\tage: 8\n\r" + "\taddress: Sunset blvrd apt 9",
                "\tid: 2\n\r" + "\tfirstName: Anton\n\r" + "\tlastName: Shlyapkin\n\r" + "\tmiddleName: Kazbekovich\n\r" + "\tage: 88\n\r" + "\taddress: Kazakova 22 apt 8",
                "\tid: 3\n\r" + "\tfirstName: Egor\n\r" + "\tlastName: Kolbaskin\n\r" + "\tmiddleName: Petrovich\n\r" + "\tage: 15\n\r" + "\taddress: Gagarina 15 apt 22",
                "\tid: 4\n\r" + "\tfirstName: Pavel\n\r" + "\tlastName: Potolkov\n\r" + "\tmiddleName: Pavlovich\n\r" + "\tage: 100\n\r" + "\taddress: Geroev Krut h 58"
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
                "\tid: 1\n\r" + "\tfirstName: Vasia\n\r" + "\tlastName: Pupkin\n\r" + "\tmiddleName: Ivanovich\n\r" + "\tage: 8\n\r" + "\taddress: Sunset blvrd apt 9",
                "\tid: 2\n\r" + "\tfirstName: Anton\n\r" + "\tlastName: Shlyapkin\n\r" + "\tmiddleName: Kazbekovich\n\r" + "\tage: 88\n\r" + "\taddress: Kazakova 22 apt 8",
                "\tid: 3\n\r" + "\tfirstName: Egor\n\r" + "\tlastName: Kolbaskin\n\r" + "\tmiddleName: Petrovich\n\r" + "\tage: 15\n\r" + "\taddress: Gagarina 15 apt 22",
                "\tid: 4\n\r" + "\tfirstName: Pavel\n\r" + "\tlastName: Potolkov\n\r" + "\tmiddleName: Pavlovich\n\r" + "\tage: 100\n\r" + "\taddress: Geroev Krut h 58"
        };

        assertArrayEquals(expected, actual);
    }

    @Test
    void toFormatStrTest() {
        String expected = "\tid: 1\n\r" + "\tfirstName: Vasia\n\r" + "\tlastName: Pupkin\n\r" + "\tmiddleName: Ivanovich\n\r" + "\tage: 8\n\r" + "\taddress: Sunset blvrd apt 9-" +
                "\tid: 2\n\r" + "\tfirstName: Anton\n\r" + "\tlastName: Shlyapkin\n\r" + "\tmiddleName: Kazbekovich\n\r" + "\tage: 88\n\r" + "\taddress: Kazakova 22 apt 8-" +
                "\tid: 3\n\r" + "\tfirstName: Egor\n\r" + "\tlastName: Kolbaskin\n\r" + "\tmiddleName: Petrovich\n\r" + "\tage: 15\n\r" + "\taddress: Gagarina 15 apt 22-" +
                "\tid: 4\n\r" + "\tfirstName: Pavel\n\r" + "\tlastName: Potolkov\n\r" + "\tmiddleName: Pavlovich\n\r" + "\tage: 100\n\r" + "\taddress: Geroev Krut h 58-";
        Parent[] data = {p1, p2, p3, p4};
        String actual = af.toFormatStr(data);

        assertEquals(expected, actual);
    }

    @Test
    void FromFormatStrTest() {
        String data = "\tid: 1\n\r" + "\tfirstName: Vasia\n\r" + "\tlastName: Pupkin\n\r" + "\tmiddleName: Ivanovich\n\r" + "\tage: 8\n\r" + "\taddress: Sunset blvrd apt 9-" +
                "\tid: 2\n\r" + "\tfirstName: Anton\n\r" + "\tlastName: Shlyapkin\n\r" + "\tmiddleName: Kazbekovich\n\r" + "\tage: 88\n\r" + "\taddress: Kazakova 22 apt 8-" +
                "\tid: 3\n\r" + "\tfirstName: Egor\n\r" + "\tlastName: Kolbaskin\n\r" + "\tmiddleName: Petrovich\n\r" + "\tage: 15\n\r" + "\taddress: Gagarina 15 apt 22-" +
                "\tid: 4\n\r" + "\tfirstName: Pavel\n\r" + "\tlastName: Potolkov\n\r" + "\tmiddleName: Pavlovich\n\r" + "\tage: 100\n\r" + "\taddress: Geroev Krut h 58-";
        Parent[] expected = {p1, p2, p3, p4};
        Parent[] actual = af.fromFormatStr(data);

        assertArrayEquals(expected, actual);
    }
}
