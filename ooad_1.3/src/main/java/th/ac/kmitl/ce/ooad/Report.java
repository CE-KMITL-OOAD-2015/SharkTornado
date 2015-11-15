package th.ac.kmitl.ce.ooad;
/*
 * Created by Nut on 10/24/2015.
 */
public class Report extends ReportTemplate{
    String vmIP;
    boolean isPaid;

    public Report(String vmIP, boolean isPaid) {
        this.vmIP = vmIP;
        this.isPaid = isPaid;
    }

    public Report(CloudProvider cloudProvider, int vmNumber, double[] cpus, double[] mems, double[] networks, int[] storage, String vmIP, boolean isPaid) {
        super(cloudProvider, vmNumber, cpus, mems, networks, storage);
        this.vmIP = vmIP;
        this.isPaid = isPaid;
    }

    public String getVmIP() {
        return vmIP;
    }

    public void setVmIP(String vmIP) {
        this.vmIP = vmIP;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
