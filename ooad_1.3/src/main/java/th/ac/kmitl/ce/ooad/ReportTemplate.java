package th.ac.kmitl.ce.ooad;

/**
 * Created by Nut on 10/24/2015.
 */
public abstract class ReportTemplate {
    CloudProvider cloudProvider;
    int vmNumber;
    double[] cpus;
    double[] mems;
    double[] networks;
    int[] storage;


    public ReportTemplate() {
    }

    public ReportTemplate(CloudProvider cloudProvider, int vmNumber, double[] cpus, double[] mems, double[] networks, int[] storage) {
        this.cloudProvider = cloudProvider;
        this.vmNumber = vmNumber;
        this.cpus = cpus;
        this.mems = mems;
        this.networks = networks;
        this.storage = storage;
    }

    public CloudProvider getCloudProvider() {
        return cloudProvider;
    }

    public void setCloudProvider(CloudProvider cloudProvider) {
        this.cloudProvider = cloudProvider;
    }

    public int getVmNumber() {
        return vmNumber;
    }

    public void setVmNumber(int vmNumber) {
        this.vmNumber = vmNumber;
    }

    public double[] getCpus() {
        return cpus;
    }

    public void setCpus(double[] cpus) {
        this.cpus = cpus;
    }

    public double[] getMems() {
        return mems;
    }

    public void setMems(double[] mems) {
        this.mems = mems;
    }

    public double[] getNetworks() {
        return networks;
    }

    public void setNetworks(double[] networks) {
        this.networks = networks;
    }

    public int[] getStorage() {
        return storage;
    }

    public void setStorage(int[] storage) {
        this.storage = storage;
    }
}
