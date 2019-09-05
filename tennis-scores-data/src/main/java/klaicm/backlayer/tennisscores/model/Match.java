package klaicm.backlayer.tennisscores.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Match extends BaseEntity {

    @ManyToOne
    private Player player;

    private Long playerW;
    private Long playerL;

    private String result;
    private LocalDate date;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Long getPlayerW() {
        return playerW;
    }

    public void setPlayerW(Long playerW) {
        this.playerW = playerW;
    }

    public Long getPlayerL() {
        return playerL;
    }

    public void setPlayerL(Long playerL) {
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
