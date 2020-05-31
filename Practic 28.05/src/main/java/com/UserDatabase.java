package com;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase {

    private static List<User> database = new ArrayList<>();

    protected static void addUser(User user) {
        database.add(user);
    }

    protected static void removeUser(User user) {
        database.remove(user);
    }

    protected static void replaceUser(User targetUser, User newUser) {

        for (User user : database) {

            if (targetUser.equals(user)) {
                database.remove(targetUser);
                database.add(newUser);
            }
        }
    }
}
