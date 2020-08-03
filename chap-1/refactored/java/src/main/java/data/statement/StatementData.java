package data.statement;

import data.invoice.Invoice;
import lombok.Getter;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Getter
public class StatementData {

    private String customer;
    private List<PerformaceData> performaces;

    public StatementData(Invoice invoice) {
        customer = invoice.getCustomer();

        performaces = invoice.getPerformaces().stream()
                .map( performace -> new PerformaceData(performace))
                .collect(toList());
    }

    public double totalAmount() {
       return performaces.stream()
               .map(PerformaceData::getAmount)
               .reduce(0d, Double::sum);
    }

    public double totalVolumeCredits(){
        return performaces.stream()
                .map(PerformaceData::getVolumeCredits)
                .reduce(0d, Double::sum);
    }
}