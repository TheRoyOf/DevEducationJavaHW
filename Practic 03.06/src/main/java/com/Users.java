package com;

import com.interfaces.IAuthorization;
import com.interfaces.IRegistration;

import java.util.HashMap;
import java.util.Map;

public class Users implements IAuthorization, IRegistration {

    Map<String, User> users = new HashMap<String, User>();

    public User authorization(String login, String password) {
        if (users.containsKey(login) && users.get(login).getPassword().equals(password) && !users.get(login).isBanned()) {
            return users.get(login);
        }
        return null;
    }

    public User registration(String login, String password) {
        if (login.isEmpty() || password.isEmpty()) {
            return null;
        }
        if (users.containsKey(login)) {
            return null;
        }
        User user = new User(login, password);
        users.put(login, user);
        return user;
    }
}
