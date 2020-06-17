package com.interfaces;

import com.User;

public interface IAuthorization {

    User authorization(String login, String password);

}
