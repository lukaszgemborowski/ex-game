import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.gemborowski.Main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Main.class)
public class AcceptanceTests {
    @Autowired
    private MockMvc mockMvc;

    public String loadResource(String name) {
        // Load the JSON file as an InputStream
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(name);

        return new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));
    }

    public void executeTest(String endpoint, String inputJsonFile, String expectedOutputJsonFile) throws Exception {
        String inputJson = loadResource(inputJsonFile);
        String expectedOutputJson = loadResource(expectedOutputJsonFile);

        mockMvc.perform(MockMvcRequestBuilders.post(endpoint)
                        .contentType("application/json")
                        .content(inputJson))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedOutputJson));
    }

    @Test
    public void onlineGameCalculateRef1() throws Exception {
        executeTest("/onlinegame/calculate", "online_game_input_1.json", "online_game_output_1.json");
    }

    @Test
    public void ATMRef1() throws Exception {
        executeTest("/atms/calculateOrder", "atm_input_1.json", "atm_output_1.json");
    }

    @Test
    public void ATMRef2() throws Exception {
        executeTest("/atms/calculateOrder", "atm_input_2.json", "atm_output_2.json");
    }

    @Test
    public void TransactionsRef1() throws Exception {
        executeTest("/transactions/report", "transactions_input_1.json", "transactions_output_1.json");
    }
}
