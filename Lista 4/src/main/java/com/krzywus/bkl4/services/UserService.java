package com.krzywus.bkl4.services;

import com.krzywus.bkl4.model.User;

public interface UserService {
    boolean registerNewUserAccount(final String username, final String password);

    boolean login(String username, String password);

}
