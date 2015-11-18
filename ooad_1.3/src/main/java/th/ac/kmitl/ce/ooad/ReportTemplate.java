package th.ac.kmitl.ce.ooad;

import java.util.Date;

/**
 * Created by Nut on 10/24/2015.
 */
public abstract class ReportTemplate {
    CloudProvider cloudProvider;
    double[] cpus;
    double[] mems;
    double[] networks;
    int[] storage;
    Date timestamp;

    public ReportTemplate() {
        timestamp = new Date();
    }

    public ReportTemplate(CloudProvider cloudProvider, double[] cpus, double[] mems, double[] networks, int[] storage) {
        this.cloudProvider = cloudProvider;
        this.cpus = cpus;
        this.mems = mems;
        this.networks = networks;
        this.storage = storage;
        this.timestamp = new Date();
    }

    public CloudProvider getCloudProvider() {
        return cloudProvider;
    }

    public void setCloudProvider(CloudProvider cloudProvider) {
        this.cloudProvider = cloudProvider;
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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
