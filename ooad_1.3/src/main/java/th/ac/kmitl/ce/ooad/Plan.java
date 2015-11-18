package th.ac.kmitl.ce.ooad;

/**
 * Created by Nut on 10/12/2015.
 */
public class Plan {
    public CloudProvider cloudProv;
    public double monthlyRate, cpu, mem, network;
    public int storage, planNum;

    public Plan(CloudProvider cloudProv, double monthlyRate,
                double cpu, double mem, double network, int storage, int planNum) {
        this.cloudProv = cloudProv;
        this.monthlyRate = monthlyRate;
        this.cpu = cpu;
        this.mem = mem;
        this.network = network;
        this.storage = storage;
        this.planNum = planNum;
    }

    public double getMonthlyRate() {
        return monthlyRate;
    }

}
