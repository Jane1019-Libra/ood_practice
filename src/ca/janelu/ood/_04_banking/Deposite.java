package ca.janelu.ood._04_banking;

public class Deposite extends Transaction{
    private int amount;

    public Deposite(int customerId, int tellerId, int amount) {
        super(customerId, tellerId);
        this.amount = amount;
    }

    @Override
    public String getTransactionDes() {
        return "Teller "+ getTellerId() + " deposited " + amount + " to account " +getCustomerId() ;
    }
}
