package klaicm.backlayer.tennisscores.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Player extends BaseEntity {

    private String firstName;
    private String lastName;
    private Integer points;
    private Integer wins;
    private Integer loses;

    @ManyToMany
    @JoinTable(name = "player_match",
        joinColumns = @JoinColumn(name = "player_id"), inverseJoinColumns = @JoinColumn(name = "match_id"))
    private Set<Match> matches;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "player")
    private Set<Season> seasons;

    @Lob
    private Byte[] image;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLoses() {
        return loses;
    }

    public void setLoses(Integer loses) {
        this.loses = loses;
    }

    public Set<Match> getMatches() {
        return matches;
    }

    public void setMatches(Set<Match> matches) {
        this.matches = matches;
    }

    public Set<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(Set<Season> seasons) {
        this.seasons = seasons;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }
}
