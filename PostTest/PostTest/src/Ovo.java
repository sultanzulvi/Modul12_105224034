public class Ovo implements PaymentMethod, Refundable {
    @Override
    public void pay(double amount) {
        System.out.println("API OVO untuk pembayaran sebesar: " + amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refund melalui API OVO sebesar: " + amount);
    }
}