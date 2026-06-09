public class NotificationService {
    private final EmailNotifier emailNotifier;

    public NotificationService(EmailNotifier emailNotifier) {
        this.emailNotifier = emailNotifier;
    }

    public void notifyReceipt(String orderId) {
        emailNotifier.sendEmail("Resi untuk pesanan " + orderId);
    }
}