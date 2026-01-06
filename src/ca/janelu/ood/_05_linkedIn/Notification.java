package ca.janelu.ood._05_linkedIn;

public abstract class Notification {
    Account account;

    public Notification(Account account) {
        this.account = account;
    }

    public abstract void getNotification();
}
