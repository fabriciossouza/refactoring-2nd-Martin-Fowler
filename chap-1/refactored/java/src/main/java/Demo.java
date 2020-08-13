import data.invoice.Invoice;
import data.invoice.Performance;
import data.play.AsLike;
import data.play.Hamlet;
import data.play.Othello;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String...args) throws Exception {

        Invoice invoice = new Invoice();

        invoice.setCustomer("BigCo");
        List<Performance> performances = new ArrayList();

        performances.add(new Performance(new Hamlet(), 55));
        performances.add(new Performance(new AsLike(), 35));
        performances.add(new Performance(new Othello(), 40));

        invoice.setPerformances(performances);

        Statement statement = new Statement(invoice);

        String text = statement.renderPlainText();
        System.out.println(text);

        String hml = statement.renderHtml();
        System.out.println(hml);
    }
}