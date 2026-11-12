package com.gamemanager.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void storesUsernameAndPassword() {
        User user = new User("emmet", "secret");
        assertEquals("emmet", user.getUsername());
        assertEquals("secret", user.getPassword());
    }
}
