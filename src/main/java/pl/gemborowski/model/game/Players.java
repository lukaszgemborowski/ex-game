package pl.gemborowski.model.game;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Players {
    private int groupCount;
    private List<Clan> clans;

    @JsonCreator
    public Players(@JsonProperty("groupCount") int groupCount,
                   @JsonProperty("clans") List<Clan> clans) {
        this.groupCount = groupCount;
        this.clans = clans;
    }

    public int getGroupCount() {
        return groupCount;
    }

    public void setGroupCount(int groupCount) {
        this.groupCount = groupCount;
    }

    public List<Clan> getClans() {
        return clans;
    }

    public void setClans(List<Clan> clans) {
        this.clans = clans;
    }
}