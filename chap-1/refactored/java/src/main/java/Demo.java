import data.invoice.Invoice;
import data.invoice.Performace;
import data.play.AsLike;
import data.play.Hamlet;
import data.play.Othello;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String...args) throws Exception {

        Invoice invoice = new Invoice();

        invoice.setCustomer("BigCo");
        List<Performace> performances = new ArrayList();

        performances.add(new Performace(new Hamlet(), 55));
        performances.add(new Performace(new AsLike(), 35));
        performances.add(new Performace(new Othello(), 40));

        invoice.setPerformaces(performances);

        Statement statement = new Statement(invoice);

        String result = statement.stantement();
        System.out.println(result);

    }
}