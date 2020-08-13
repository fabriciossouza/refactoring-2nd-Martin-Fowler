import data.invoice.Invoice;
import data.invoice.Performance;
import data.play.Play;
import data.statement.StatementData;
import data.statement.PerformaceData;

import java.text.NumberFormat;
import java.util.Locale;

import static java.lang.String.format;
import static java.text.NumberFormat.getCurrencyInstance;

public class Statement {

    private StatementData data;

    public Statement(Invoice invoice) {
        this.data = new StatementData(invoice);
    }

    public Statement(StatementData data) {
        this.data = data;
    }

    public String renderPlainText() {

        String result = format("Statement for %s\n",data.getCustomer());

        for(PerformaceData perf : data.getPerformaces()){
            Play play = perf.getPlay();
            result += format(" %s: %s %s seats\n", play.getType(), usd(perf.getAmount()), perf.getPerformance().getAudience());
        }

        result += format("Amount owed is %s \n", usd(data.totalAmount()));
        result += format("You earned %.2f credits\n", data.totalVolumeCredits());

        return result;
    }

    public String renderHtml() {
        String result = format("<h1>Statement for %s</h1>\n",data.getCustomer());
        result += "<table>\n";
        result += "<tr><th>play</th><th>seats</th><th>cost</th></tr>\n";
        for (PerformaceData performaceData : data.getPerformaces()) {
            Performance performance = performaceData.getPerformance();
            result += format("  <tr><td>%s</td><td>%s</td>", performance.getPlay().getName(), performance.getAudience());
            result += format("<td>%s</td></tr>\n", usd(performaceData.getAmount()));
        }
        result += "</table>\n";
        result += format("<p>Amount owed is <em>%s</em></p>\n", usd(data.totalAmount()) );
        result += format("<p>You earned <em>%s</em> credits</p>\n", data.totalVolumeCredits());

        return result;
    }

    private String usd(double number){
        Locale locale = new Locale("en", "US");
        NumberFormat currencyFormatter = getCurrencyInstance(locale);
        return currencyFormatter.format(number/100);
    }
}