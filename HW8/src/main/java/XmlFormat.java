public class XmlFormat extends AbstractFormat {
    @Override
    public Parent fromFormat(String str) {
        str = str.replaceAll("[^a-zA-Z0-9]", " ");
        str = str.trim().replaceAll(" +", " ");
        String[] arr = str.split(" ");

        long id = Long.parseLong(arr[1]);
        String firstName = arr[4];
        String lastName = arr[7];
        String middleName = arr[10];
        int age = Integer.parseInt(arr[13]);
        String address = arr[16] + " " + arr[17] + " " + arr[18] + " " + arr[19];

        return new Parent(id, firstName, lastName, middleName, age, address);
    }

    @Override
    public String toFormatStr(Parent[] arr) {
        String[] result = new String[arr.length];
        StringBuilder build = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            result[i] = toFormat(arr[i]) + "-";
        }

        for (String s : result) {
            build.append(s);
        }
        return build.toString();
    }

    @Override
    public Parent[] fromFormatStr(String str) {
        String[] arr = str.split("-");
        Parent[] result = new Parent[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] = fromFormat(arr[i]);
        }
        return result;
    }

    @Override
    public String toFormat(Parent p) {
        return "<id>" + p.getId() + "</id>" + "\n\r" + "<firstName>" + p.getFirstName() + "</firstName>" + "\n\r"
                + "<lastName>" + p.getLastName() + "</lastName>" + "\n\r" + "<middleName>" + p.getMiddleName() + "</middleName>" + "\n\r"
                + "<age>" + p.getAge() + "</age>" + "\n\r" + "<address>" + p.getAddress() + "</address>";
    }
}
