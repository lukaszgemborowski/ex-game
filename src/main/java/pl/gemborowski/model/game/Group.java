package pl.gemborowski.model.game;

import java.util.ArrayList;
import java.util.List;

public class Group extends ArrayList<Clan> {
    public Group() {
    }

    public Group(List<Clan> clans) {
        super(clans);
    }
}