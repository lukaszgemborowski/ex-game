package pl.gemborowski;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gemborowski.model.game.Clan;
import pl.gemborowski.model.game.Group;
import pl.gemborowski.model.game.Order;
import pl.gemborowski.model.game.Players;

import java.util.*;

@RestController
@RequestMapping("/")
public class MyRestController {
    public static Order generateOrder(List<Clan> clans, int groupSize) {
        // Sort clans by points and number of players
        Collections.sort(clans, new Comparator<Clan>() {
            @Override
            public int compare(Clan c1, Clan c2) {
                int pointsComparison = Integer.compare(c2.getPoints(), c1.getPoints());
                if (pointsComparison != 0) {
                    return pointsComparison;
                } else {
                    return Integer.compare(c1.getNumberOfPlayers(), c2.getNumberOfPlayers());
                }
            }
        });

        List<Group> groups = new ArrayList<>();

        while (!clans.isEmpty())
        {
            List<Clan> groupClans = new ArrayList<>();

            int currentGroupSize = 0;

            for (Clan clan : clans)
            {
                if (currentGroupSize + clan.getNumberOfPlayers() <= groupSize)
                {
                    groupClans.add(clan);
                    currentGroupSize += clan.getNumberOfPlayers();
                }
            }

            groups.add(new Group(groupClans));
            clans.removeAll(groupClans);
        }

        return new Order(groups);
    }

    @PostMapping(value = "/onlinegame/calculate", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<Order> calculate(@RequestBody Players players) {
        List<Clan> clans = players.getClans();
        int groupSize = players.getGroupCount();

        // Generate the order of groups
        Order order = generateOrder(clans, groupSize);

        return ResponseEntity.ok(order);
    }
}