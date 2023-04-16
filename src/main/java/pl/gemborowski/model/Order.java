package pl.gemborowski.model;

import java.util.ArrayList;
import java.util.List;

public class Order extends ArrayList<Group> {
    public Order() {
    }

    public Order(List<Group> groups) {
        super(groups);
    }
}