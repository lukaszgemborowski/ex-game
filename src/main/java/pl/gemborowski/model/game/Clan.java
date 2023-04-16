package pl.gemborowski.model.game;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Clan {
    private int numberOfPlayers;
    private int points;

    @JsonCreator
    public Clan(@JsonProperty("numberOfPlayers") int numberOfPlayers,
                @JsonProperty("points") int points) {
        this.numberOfPlayers = numberOfPlayers;
        this.points = points;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
