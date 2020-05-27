public abstract class AbstractFormat {

    public String[] toFormatArr(Parent[] array) {
        String[] result = new String[array.length];

        for (int i = 0; i < array.length; i++) {
            result[i] = toFormat(array[i]);
        }
        return result;
    }

    public Parent[] fromFormatArr(String[] array) {
        Parent[] result = new Parent[array.length];

        for (int i = 0; i < array.length; i++) {
            result[i] = fromFormat(array[i]);
        }
        return result;
    }

    public abstract String toFormat(Parent p);

    public abstract Parent fromFormat(String str);

    public abstract String toFormatStr(Parent[] arr);

    public abstract Parent[] fromFormatStr(String str);

}
