package Enums;

// Small enum with a method
public enum Currency {
    USD(1.0), EUR(0.85), JPY(110.0);

    private final double conversionRate;

    Currency(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public static double convert(double amount, Currency from, Currency to) {
        return amount * (to.getConversionRate() / from.getConversionRate());
    }
}

