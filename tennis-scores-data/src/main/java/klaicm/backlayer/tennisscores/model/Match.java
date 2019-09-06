package klaicm.backlayer.tennisscores.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Match extends BaseEntity {

    @ManyToMany(mappedBy = "matches")
    private Set<Player> players;

    private Long playerW;
    private Long playerL;

    private String result;
    private LocalDate date;

    public Set<Player> getPlayer() {
        return players;
    }

    public void setPlayer(Set<Player> player) {
        this.players = player;
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
