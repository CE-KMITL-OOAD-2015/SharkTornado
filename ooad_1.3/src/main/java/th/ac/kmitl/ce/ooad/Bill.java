package th.ac.kmitl.ce.ooad;

import java.util.Date;
import java.util.List;

/**
 * Created by Nut on 10/24/2015.
 */
public class Bill {
    List<Plan> plans;
    double total;
    boolean isPaid;
    Date timestamp;

    public Bill() {
        timestamp = new Date();
        isPaid = false;
    }

    public Bill(List<Plan> plans, double total, boolean isPaid) {
        this.plans = plans;
        this.total = total;
        timestamp = new Date();
        this.isPaid = isPaid;
    }

    public List<Plan> getPlans() {
        return plans;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public void setPlans(List<Plan> plans) {
        this.plans = plans;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
