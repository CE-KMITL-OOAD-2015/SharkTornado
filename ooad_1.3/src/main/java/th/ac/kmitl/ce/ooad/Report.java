package th.ac.kmitl.ce.ooad;

/**
 * Created by Nut on 10/24/2015.
 */
public class Report extends ReportTemplate{
    public Report() {
    }

    public Report(CloudProvider cloudProvider, int vmNumber, double[] cpus, double[] mems, double[] networks, int[] storage) {
        super(cloudProvider, vmNumber, cpus, mems, networks, storage);
    }
}
