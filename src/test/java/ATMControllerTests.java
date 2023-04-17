import org.junit.jupiter.api.Test;
import pl.gemborowski.controllers.ATMController;
import pl.gemborowski.model.atmservice.ATM;
import pl.gemborowski.model.atmservice.ServiceTasks;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ATMControllerTests {
    @Test
    void testEmptyInput() {
        // test empty input to ATMController.calculateOrder function
        List<ATM> atms = ATMController.calculateOrder(new ServiceTasks());
        assertEquals(0, atms.size());
    }
}
