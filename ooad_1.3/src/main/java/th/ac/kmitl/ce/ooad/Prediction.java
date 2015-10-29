package th.ac.kmitl.ce.ooad;

/**
 * Created by Nut on 10/29/2015.
 */
public class Prediction extends ReportTemplate{
    public Prediction(CloudProvider cloudProvider, int vmNumber, double[] cpus, double[] mems, double[] networks, int[] storage) {
        super(cloudProvider, vmNumber, cpus, mems, networks, storage);
    }

    public Prediction() {
    }


}
