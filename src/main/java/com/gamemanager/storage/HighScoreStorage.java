package com.gamemanager.storage;

import com.gamemanager.model.HighScore;
import java.util.List;

/** Reads and writes the single high_scores.txt file shared by all games. TODO: implement. */
public class HighScoreStorage {

    private final String filePath = "data/high_scores.txt";

    public List<HighScore> loadScores() {
        // TODO
        return List.of();
    }

    public void saveScores(List<HighScore> scores) {
        // TODO
    }

    public String getFilePath() {
        return filePath;
    }
}
