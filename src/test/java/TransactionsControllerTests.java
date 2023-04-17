import org.junit.jupiter.api.Test;
import pl.gemborowski.model.transactions.Account;
import pl.gemborowski.model.transactions.Transaction;
import pl.gemborowski.controllers.TransactionsController;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionsControllerTests {
    @Test
    void testEmptyTransactionsInput() {
        List<Account> transactions = TransactionsController.processTransactions(new ArrayList<Transaction>());
        assertEquals(0, transactions.size());
    }
}
