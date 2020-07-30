import data.invoice.Invoice;
import data.invoice.Performace;
import data.play.Play;

import java.util.List;

import static data.play.PlayType.COMEDY;
import static java.lang.String.format;

public class Statement {

    public String stantement(Invoice invoice, List<Play> plays) throws Exception {

        double totalAmount = 0;
        double volumeCredits = 0;
        String result = format("Statement for %s\n",invoice.getCustomer());

        for(Performace perf : invoice.getPerformaces()){

            Play play = perf.getPlay();
            double thisAmount = 0;

            switch (play.getType()){
                case TRAGEDY:
                    thisAmount = 40000;
                    if (perf.getAudience() > 30) {
                        thisAmount += 1000 * (perf.getAudience() - 30);
                    }
                    break;
                case COMEDY:
                    thisAmount = 30000;
                    if (perf.getAudience() > 20) {
                        thisAmount += 10000 + 500 * (perf.getAudience() - 20);
                    }
                    thisAmount += 300 * perf.getAudience();
                    break;
                default:
                    throw new Exception("unknown type: " + play.getType());
            }

            volumeCredits += Math.max(perf.getAudience() - 30, 0);
            if (COMEDY == play.getType()) volumeCredits += Math.floor(perf.getAudience() / 5);



            result += format(" %s: %.2f %s seats\n", play.getType(), thisAmount/100, perf.getAudience());
            totalAmount += thisAmount;
        }

        result += format("Amount owed is %1$,.2f \n", totalAmount / 100);
        result += format("You earned %1$,.2f credits\n", volumeCredits);

        return result;
    }
}