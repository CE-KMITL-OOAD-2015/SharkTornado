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

    public List<Plan> getPlans() {
        return plans;
    }

    public void setPlans(List<Plan> plans) {
        this.plans = plans;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
