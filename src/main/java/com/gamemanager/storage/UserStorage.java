package com.gamemanager.storage;

import com.gamemanager.model.User;
import java.util.List;

/** Reads and writes user_accounts.txt. TODO: implement load/save/createUser/authenticate. */
public class UserStorage {

    private final String filePath = "data/user_accounts.txt";

    public List<User> loadUsers() {
        // TODO
        return List.of();
    }

    public void saveUsers(List<User> users) {
        // TODO
    }

    public String getFilePath() {
        return filePath;
    }
}
