package strategy;

public class InternationalUKTStrategy implements UKTCalculationStrategy {
    @Override
    public double hitungTagihan(int totalSks) {
        return 15000000 + (totalSks * 500000);
    }
}