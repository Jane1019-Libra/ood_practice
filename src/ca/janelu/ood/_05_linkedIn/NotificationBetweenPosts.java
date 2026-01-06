package ca.janelu.ood._05_linkedIn;

public class NotificationBetweenPosts extends Notification{
    Post post;
    String action;

    public NotificationBetweenPosts(Account account, Post post, String action) {
        super(account);
        this.post = post;
        this.action = action;
    }

    @Override
    public void getNotification() {
        System.out.println(account.getUserName() + " has " + action + " post: " + post.getPostId());
    }

}
