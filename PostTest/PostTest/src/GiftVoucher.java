public class GiftVoucher implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Memotong saldo Gift Voucher: " + amount);
    }
}