public class JsonFormat extends AbstractFormat {

    @Override
    public Parent fromFormat(String str) {
        str = str.replaceAll("[^a-zA-Z0-9]", " ");
        str = str.trim().replaceAll(" +", " ");
        String[] array = str.split(" ");

        long id = Long.parseLong(array[1]);
        String firstName = array[3];
        String lastName = array[5];
        String middleName = array[7];
        int age = Integer.parseInt(array[9]);
        String address = array[11] + " " + array[12] + " " + array[13] + " " + array[14];

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
        return "{" + "\"Id\" : " + "\"" + p.getId() + "\"" + ", " + "\"firstName\" : " +
                "\"" + p.getFirstName() + "\"" + ", " + "\"lastName\" : " + "\"" + p.getLastName() +
                "\"" + ", " + "\"middleName\" : " + "\"" + p.getMiddleName() + "\"" + ", " +
                "\"Age\" : " + "\"" + p.getAge() + "\"" + ", " + "\"Address\" : " +
                "\"" + p.getAddress() + "\"" + "}";
    }
}
