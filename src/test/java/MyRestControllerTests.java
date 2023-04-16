
import org.junit.jupiter.api.Test;
import pl.gemborowski.MyRestController;
import pl.gemborowski.model.Clan;
import pl.gemborowski.model.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyServiceTest {

    @Test
    void testGenerateOrder() {
        // Prepare input data
        // Prepare input data
        List<Clan> clans = new ArrayList<>(Arrays.asList(
                new Clan(2, 70), // 1
                new Clan(4, 50), // 2
                new Clan(6, 60), // 1
                new Clan(3, 45), // 2
                new Clan(1, 15), // 1
                new Clan(1, 12), // 1
                new Clan(4, 40), // 3
                new Clan(5, 40)  // 3
        ));
        int groupSize = 10;

        // Call the generateOrder method
        Order order = MyRestController.generateOrder(clans, groupSize);

        // Check if the order has the correct number of groups
        assertEquals(3, order.size());

        assertEquals(4, order.get(0).size());
        assertEquals(2, order.get(1).size());
        assertEquals(2, order.get(2).size());
    }
}