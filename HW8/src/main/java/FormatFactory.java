public class FormatFactory {

    FormatFactory(){
    }

    public static AbstractFormat choose(String format) {

        switch (format) {
            case ConstantFormat.JSON_FORMAT:
                return new JsonFormat();
            case ConstantFormat.XML_FORMAT:
                return new XmlFormat();
            case ConstantFormat.YML_FORMAT:
                return new YmlFormat();
            default:
                return null;
        }
    }
}
