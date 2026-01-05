package ca.janelu.ood._04_banking;

public abstract class Transaction {
    private int customerId;
    private int tellerId;

    public Transaction(int customerId, int tellerId) {
        this.customerId = customerId;
        this.tellerId = tellerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getTellerId() {
        return tellerId;
    }

    public abstract String getTransactionDes();
}
