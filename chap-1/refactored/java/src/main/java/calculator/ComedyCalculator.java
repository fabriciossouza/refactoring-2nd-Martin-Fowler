package calculator;

import data.invoice.Performance;

import static java.lang.Math.floor;

public class ComedyCalculator extends PerformaceCalculator {

    public ComedyCalculator(Performance performance) {
        super(performance);
    }

    @Override
    public double amount() {
        double result = 30000;
        if (performance.getAudience() > 20) {
            result += 10000 + 500 * (performance.getAudience() - 20);
        }
        result += 300 * performance.getAudience();
        return result;
    }

    @Override
    public double volumeCredits() {
        return super.volumeCredits() + floor(this.performance.getAudience() / 5);
    }
}
