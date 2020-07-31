package data.invoice;

import java.util.List;

public class Invoice {

    private String customer;
    private List<Performace> performaces;

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setPerformaces(List<Performace> performaces) {
        this.performaces = performaces;
    }

    public String getCustomer() {
        return customer;
    }

    public List<Performace> getPerformaces() {
        return performaces;
    }
}
