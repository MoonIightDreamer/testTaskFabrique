package com.github.MoonlightDreamer.TestData;

import com.github.MoonlightDreamer.model.Role;
import com.github.MoonlightDreamer.model.User;

import java.util.Date;

public class UserTestData {

    public static final int USER_ID = 1;
    public static final int ADMIN_ID = 2;
    public static final int NOT_FOUND = 25;

    public static final User user = new User(USER_ID, "User", "user@gmail.com", "password", Role.USER);
    public static final User admin = new User(ADMIN_ID, "Admin", "admin@gmail.com", "admin", Role.ADMIN, Role.USER);
}
