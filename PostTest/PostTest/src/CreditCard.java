public class CreditCard implements PaymentMethod, Refundable {
    @Override
    public void pay(double amount) {
        System.out.println("API Bank Kartu Kredit: " + amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refund ke API Bank sebesar: " + amount);
    }
}