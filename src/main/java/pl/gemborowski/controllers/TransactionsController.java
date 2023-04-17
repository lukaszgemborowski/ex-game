package pl.gemborowski.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.gemborowski.model.transactions.Account;
import pl.gemborowski.model.transactions.Transaction;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TransactionsController {
    public static List<Account> processTransactions(List<Transaction> transactions) {
        Map<String, Account> accounts = new HashMap<>();

        for (Transaction transaction : transactions) {
            String debitAccount = transaction.getDebitAccount();
            String creditAccount = transaction.getCreditAccount();
            double amount = transaction.getAmount();

            accounts.putIfAbsent(debitAccount, new Account(debitAccount));
            accounts.putIfAbsent(creditAccount, new Account(creditAccount));

            Account debit = accounts.get(debitAccount);
            Account credit = accounts.get(creditAccount);

            debit.setBalance(debit.getBalance() - amount);
            credit.setBalance(credit.getBalance() + amount);

            debit.setDebitCount(debit.getDebitCount() + 1);
            credit.setCreditCount(credit.getCreditCount() + 1);
        }

        List<Account> accountList = new ArrayList<>(accounts.values());
        accountList.sort(Comparator.comparing(Account::getAccount));

        return accountList;
    }

    @PostMapping("/transactions/report")
    public ResponseEntity<List<Account>> calculateAccountBalances(@RequestBody List<Transaction> transactions) {
        List<Account> accounts = processTransactions(transactions);
        return ResponseEntity.ok(accounts);
    }
}
