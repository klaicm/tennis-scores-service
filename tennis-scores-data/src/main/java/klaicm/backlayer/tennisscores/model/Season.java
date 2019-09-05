package klaicm.backlayer.tennisscores.model;

import javax.persistence.*;

@Entity
public class Season extends BaseEntity {

    private String seasonDescription;

    @ManyToOne
    private Player player;

    public String getSeasonDescription() {
        return seasonDescription;
    }

    public void setSeasonDescription(String seasonDescription) {
        this.seasonDescription = seasonDescription;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
