package calculator;

import data.invoice.Performance;

public abstract class PerformaceCalculator {

    protected Performance performance;

    public PerformaceCalculator(Performance performance) {
        this.performance = performance;
    }

    public abstract double amount();

    public double volumeCredits(){
        return Math.max(performance.getAudience() - 30, 0);
    }
}
