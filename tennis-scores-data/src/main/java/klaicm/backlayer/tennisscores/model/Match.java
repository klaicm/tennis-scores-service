package klaicm.backlayer.tennisscores.model;

import java.time.LocalDate;

public class Match extends BaseEntity {

    private String playerW;
    private String playerL;
    private String result;
    private LocalDate date;

    public String getPlayerW() {
        return playerW;
    }

    public void setPlayerW(String playerW) {
        this.playerW = playerW;
    }

    public String getPlayerL() {
        return playerL;
    }

    public void setPlayerL(String playerL) {
        this.playerL = playerL;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
