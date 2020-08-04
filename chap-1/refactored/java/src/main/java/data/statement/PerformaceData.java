package data.statement;

import calculator.PerformaceCalculator;
import data.invoice.Performance;
import data.play.Play;
import lombok.Getter;

import static calculator.CalculatorFactory.getCalculator;

@Getter
public class PerformaceData {

    private Play play;
    private double amount;
    private double volumeCredits;
    private Performance performance;

    public PerformaceData(Performance performance) {

        final PerformaceCalculator calculator = getCalculator(performance);

        this.performance = performance;
        this.play = performance.getPlay();
        this.amount = calculator.amount();
        this.volumeCredits = calculator.volumeCredits();
    }
}