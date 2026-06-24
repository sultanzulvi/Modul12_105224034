package strategy;

public class RegulerUKTStrategy implements UKTCalculationStrategy {
    @Override
    public double hitungTagihan(int totalSks) {
        return 5000000 + (totalSks * 250000);
    }
}
