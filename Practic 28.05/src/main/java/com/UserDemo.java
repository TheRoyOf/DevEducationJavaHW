package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDemo {

    public void addUsers() {
        User u1 = new User("Ivanov I.I",
                1000,
                "AE4652765EV",
                "ivanov",
                "12345",
                true);

        User u2 = new User("Petrov A.P",
                500,
                "AYE4652765EV",
                "petrov",
                "12345",
                false);

        User u3 = new User("Sidorov B.U",
                600,
                "AYE46545623NE",
                "sidorov",
                "12345",
                false);

        List<User> database = new ArrayList<>(Arrays.asList(u1, u2, u3));

        for (User user : database) {
            UserDatabase.addUser(user);
        }
    }

    public static User getValidUser()
    {
        return new User("ValidUser I.O",
                50000,
                "AYE00011000EV",
                "validUser",
                "validUserPassword",
                false);
    }
    public static User getInvalidUser()
    {
        return new User("no",
                0,
                "111",
                "A",
                "1111",
                false);
    }
}
