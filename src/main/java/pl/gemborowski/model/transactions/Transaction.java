package pl.gemborowski.model.transactions;

public class Transaction {
    private String debitAccount;
    private String creditAccount;
    private double amount;

    // Default constructor for JSON deserialization
    public Transaction() {}

    public Transaction(String debitAccount, String creditAccount, double amount) {
        this.debitAccount = debitAccount;
        this.creditAccount = creditAccount;
        this.amount = amount;
    }

    // Getters and Setters

    public String getDebitAccount() {
        return debitAccount;
    }

    public void setDebitAccount(String debitAccount) {
        this.debitAccount = debitAccount;
    }

    public String getCreditAccount() {
        return creditAccount;
    }

    public void setCreditAccount(String creditAccount) {
        this.creditAccount = creditAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
