package data.statement;

import data.invoice.Performace;
import data.play.Play;
import lombok.Getter;

import static data.play.PlayType.COMEDY;
import static java.lang.Math.floor;

@Getter
public class PerformaceData {

    private Play play;
    private double amount;
    private double volumeCredits;
    private Performace performace;

    public PerformaceData(Performace performace) {
        this.performace = performace;
        this.play = performace.getPlay();
        this.amount = amountFor(performace);
        this.volumeCredits = volumeCreditsFor(performace);
    }

    private double volumeCreditsFor(Performace performace) {
        double result = 0;
        result += Math.max(performace.getAudience() - 30, 0);
        if (COMEDY == performace.getPlay().getType()) result += floor(performace.getAudience() / 5);
        return result;
    }

    private double amountFor(Performace perf) {
        double result = 0;

        switch (perf.getPlay().getType()){
            case TRAGEDY:
                result = 40000;
                if (perf.getAudience() > 30) {
                    result += 1000 * (perf.getAudience() - 30);
                }
                break;
            case COMEDY:
                result = 30000;
                if (perf.getAudience() > 20) {
                    result += 10000 + 500 * (perf.getAudience() - 20);
                }
                result += 300 * perf.getAudience();
                break;
            default:
                throw new RuntimeException("unknown type: " + perf.getPlay().getType());
        }

        return result;
    }
}