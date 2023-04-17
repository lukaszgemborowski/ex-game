package pl.gemborowski.model.transactions;

public class Account {

    private String account;
    private int debitCount;
    private int creditCount;
    private double balance;

    // Default constructor for JSON deserialization
    public Account() {}

    public Account(String account) {
        this.account = account;
        this.debitCount = 0;
        this.creditCount = 0;
        this.balance = 0;
    }

    // Getters and Setters

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getDebitCount() {
        return debitCount;
    }

    public void setDebitCount(int debitCount) {
        this.debitCount = debitCount;
    }

    public int getCreditCount() {
        return creditCount;
    }

    public void setCreditCount(int creditCount) {
        this.creditCount = creditCount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
