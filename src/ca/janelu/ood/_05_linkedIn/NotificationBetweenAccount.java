package ca.janelu.ood._05_linkedIn;

public class NotificationBetweenAccount extends Notification{
    String action;
    public NotificationBetweenAccount(Account account, String action) {
        super(account);
        this.action = action;
    }

    @Override
    public void getNotification() {
        System.out.println(account.getUserName() + " has " + action + " you");
    }
}
