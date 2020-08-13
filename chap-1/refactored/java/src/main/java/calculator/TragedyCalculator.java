package calculator;

import data.invoice.Performance;

public class TragedyCalculator extends PerformaceCalculator {

    public TragedyCalculator(Performance performance) {
        super(performance);
    }

    @Override
    public double amount() {
        double result = 40000;
        if (this.performance.getAudience() > 30) {
            result += 1000 * (this.performance.getAudience() - 30);
        }
        return result;
    }
}
