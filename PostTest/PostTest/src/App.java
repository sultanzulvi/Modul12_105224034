public class App {
    public static void main(String[] args) {
        EmailNotifier emailSys = new EmailSystem();
        NotificationService notationService = new NotificationService(emailSys);
        PaymentProcessor paymentProc = new PaymentProcessor();

        OrderService orderService = new OrderService(paymentProc, notationService);

        System.out.println("TRANSAKSI 1");
        Order order1 = new Order("012", 500000);
        PaymentMethod creditCard = new CreditCard();
        orderService.saveOrder(order1, creditCard);

        System.out.println();

        System.out.println("TRANSAKSI 2");
        Order order2 = new Order("097", 150000);
        PaymentMethod voucher = new GiftVoucher();
        orderService.saveOrder(order2, voucher);
    }
}