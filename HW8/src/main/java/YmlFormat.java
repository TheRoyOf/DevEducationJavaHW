public class YmlFormat extends AbstractFormat {
    @Override
    public Parent fromFormat(String str) {
        str = str.replaceAll("[^a-zA-Z0-9]", " ");
        str = str.trim().replaceAll(" +", " ");
        String[] arr = str.split(" ");

        long id = Long.parseLong(arr[1]);
        String firstName = arr[3];
        String lastName = arr[5];
        String middleName = arr[7];
        int age = Integer.parseInt(arr[9]);
        String address = arr[11] + " " + arr[12] + " " + arr[13] + " " + arr[14];

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
        return "\tid: " + p.getId() + "\n\r" + "\tfirstName: " + p.getFirstName() + "\n\r" +
                "\tlastName: " + p.getLastName() + "\n\r" + "\tmiddleName: " + p.getMiddleName() + "\n\r"
                + "\tage: " + p.getAge() + "\n\r" + "\taddress: " + p.getAddress();
    }
}
