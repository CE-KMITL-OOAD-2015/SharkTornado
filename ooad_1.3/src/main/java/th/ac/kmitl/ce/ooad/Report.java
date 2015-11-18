package th.ac.kmitl.ce.ooad;

import java.util.Date;

import org.springframework.data.annotation.Id;

/*
 * Created by Nut on 10/24/2015.
 */
public class Report extends ReportTemplate{
    String vmIP;
    @Id String _Id;

    public Report() {
    }

    public Report(String vmIP){
        this.vmIP = vmIP;
    }

    public Report(CloudProvider cloudProvider, double[] cpus, double[] mems, double[] networks, int[] storage, Date timestamp, String vmIP) {
        super(cloudProvider, cpus, mems, networks, storage);
        this.vmIP = vmIP;
    }

    public String getVmIP() {
        return vmIP;
    }

    public void setVmIP(String vmIP) {
        this.vmIP = vmIP;
    }
}
