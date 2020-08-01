import data.invoice.Invoice;
import data.invoice.Performace;
import data.play.Play;

import java.util.List;

import static data.play.PlayType.COMEDY;
import static java.lang.Math.floor;
import static java.lang.String.format;

public class Statement {

    public String stantement(Invoice invoice, List<Play> plays) throws Exception {

        double totalAmount = 0;
        double volumeCredits = 0;
        String result = format("Statement for %s\n",invoice.getCustomer());

        for(Performace perf : invoice.getPerformaces()){

            Play play = perf.getPlay();

            volumeCredits += volumeCreditsFor(perf);

            result += format(" %s: %.2f %s seats\n", play.getType(), amountFor(perf)/100, perf.getAudience());
            totalAmount += amountFor(perf);
        }

        result += format("Amount owed is %1$,.2f \n", totalAmount / 100);
        result += format("You earned %1$,.2f credits\n", volumeCredits);

        return result;
    }

    private double volumeCreditsFor(Performace performace) {
        double result = 0;
        result += Math.max(performace.getAudience() - 30, 0);
        if (COMEDY == performace.getPlay().getType()) result += floor(performace.getAudience() / 5);
        return result;
    }

    private double amountFor(Performace perf) throws Exception {
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
                throw new Exception("unknown type: " + perf.getPlay().getType());
        }

        return result;
    }
}