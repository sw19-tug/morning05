package com.example.sw19_morning05;

import java.util.Date;

public class HighScore {
    private final Date date;
    private final String user;
    private final int highscore;

    public HighScore(Date date, String user, int highscore) {
        this.date = date;
        this.user = user;
        this.highscore = highscore;
    }

    public Date getDate() {
        return date;
    }

    public String getUser() {
        return user;
    }

    public int getHighScore() {
        return highscore;
    }
}
