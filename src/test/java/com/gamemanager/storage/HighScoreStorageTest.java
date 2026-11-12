package com.gamemanager.storage;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class HighScoreStorageTest {

    @Test
    void loadReturnsNonNullList() {
        // TODO: replace with real read/write round-trip tests using a temp file
        assertNotNull(new HighScoreStorage().loadScores());
    }
}
