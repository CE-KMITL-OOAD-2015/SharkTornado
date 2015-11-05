package th.ac.kmitl.ce.ooad;

import java.util.List;

/**
 * Created by Nut on 10/24/2015.
 */
public class Bill {
    List<Plan> plans;
    double total;

    public Bill() {
    }

    public Bill(List<Plan> plans, double total) {
        this.plans = plans;
        this.total = total;
    }

}
