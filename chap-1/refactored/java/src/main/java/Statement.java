import data.invoice.Invoice;
import data.invoice.Performace;
import data.play.Play;

import java.text.NumberFormat;
import java.util.Locale;

import static data.play.PlayType.COMEDY;
import static java.lang.Math.floor;
import static java.lang.String.format;
import static java.text.NumberFormat.getCurrencyInstance;

public class Statement {

    private Invoice invoice;

    public Statement(Invoice invoice) {
        this.invoice = invoice;
    }

    public String stantement() throws Exception {

        String result = format("Statement for %s\n",invoice.getCustomer());

        for(Performace perf : invoice.getPerformaces()){
            Play play = perf.getPlay();
            result += format(" %s: %s %s seats\n", play.getType(), usd(amountFor(perf)), perf.getAudience());
        }

        result += format("Amount owed is %s \n", usd(totalAmount()));
        result += format("You earned %.2f credits\n", totalVolumeCredits());

        return result;
    }

    private double totalAmount() throws Exception {
        double result = 0;
        for(Performace perf : invoice.getPerformaces()){
            result += amountFor(perf);
        }
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

    private String usd(double number){
        Locale locale = new Locale("en", "US");
        NumberFormat currencyFormatter = getCurrencyInstance(locale);
        return currencyFormatter.format(number/100);
    }

    private double totalVolumeCredits(){
        double volumeCredits = 0;
        for(Performace perf : invoice.getPerformaces()){
            volumeCredits += volumeCreditsFor(perf);
        }
        return volumeCredits;
    }
}