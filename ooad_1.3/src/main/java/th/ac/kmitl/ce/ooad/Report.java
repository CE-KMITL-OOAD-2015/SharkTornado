package th.ac.kmitl.ce.ooad;
/*
 * Created by Nut on 10/24/2015.
 */
public class Report extends ReportTemplate{
    String vmIP;

    public Report(String vmIP) {
        this.vmIP = vmIP;
    }

    public Report(CloudProvider cloudProvider, int vmNumber, double[] cpus, double[] mems, double[] networks, int[] storage, String vmIP) {
        super(cloudProvider, vmNumber, cpus, mems, networks, storage);
        this.vmIP = vmIP;
    }

    public String getVmIP() {
        return vmIP;
    }

    public void setVmIP(String vmIP) {
        this.vmIP = vmIP;
    }

}
