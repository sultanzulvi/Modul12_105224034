public class OrderService {
    private final PaymentProcessor paymentProcessor;
    private final NotificationService notificationService;

    public OrderService(PaymentProcessor paymentProcessor, NotificationService notificationService) {
        this.paymentProcessor = paymentProcessor;
        this.notificationService = notificationService;
    }

    public void saveOrder(Order order, PaymentMethod paymentMethod) {
        System.out.println("Menyimpan data pesanan " + order.getOrderId() + " ke database.");
        
        paymentProcessor.process(paymentMethod, order.getAmount());
        
        notificationService.notifyReceipt(order.getOrderId());
    }
}