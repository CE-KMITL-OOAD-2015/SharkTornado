package th.ac.kmitl.ce.ooad;

/**
 * Created by Nut on 10/24/2015.
 */
public class Bill {
    Plan[] plans;
    double total;

    public Bill() {
    }

    public Bill(Plan[] plans, double total) {
        this.plans = plans;
        this.total = total;
    }

    public Plan[] getPlans() {
        return plans;
    }

    public void setPlans(Plan[] plans) {
        this.plans = plans;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
