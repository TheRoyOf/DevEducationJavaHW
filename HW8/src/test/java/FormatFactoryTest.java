import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FormatFactoryTest {

    @ParameterizedTest
    @MethodSource(value = "params")
    void formatTest(String format) {
        AbstractFormat af = FormatFactory.choose(format);
        Parent expected = new Parent(1L, "Vasia",
                "Pupkin",
                "Ivanovich",
                8,
                "Sunset blvrd apt 9");
        assert af != null;
        String result = af.toFormat(expected);
        Parent actual = af.fromFormat(result);

        assertEquals(expected, actual);
    }

    private static Stream<String> params() {
        return Stream.of(ConstantFormat.JSON_FORMAT, ConstantFormat.XML_FORMAT, ConstantFormat.YML_FORMAT);
    }

}