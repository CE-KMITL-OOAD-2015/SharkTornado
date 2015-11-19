package th.ac.kmitl.ce.ooad;

import java.util.Date;
import java.util.List;

/**
 * Created by Nut on 10/24/2015.
 */
public abstract class ReportTemplate {
    CloudProvider cloudProvider;
    List<Double> cpus;
    List<Double> mems;
    List<Double> networks;
    List<Integer> storage;
    Date timestamp;

    public ReportTemplate() {
        timestamp = new Date();
    }

    public ReportTemplate(CloudProvider cloudProvider, List<Double> cpus, List<Double> mems, List<Double> networks, List<Integer> storage) {
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

    public List<Double> getCpus() {
        return cpus;
    }

    public void setCpus(List<Double> cpus) {
        this.cpus = cpus;
    }

    public List<Double> getMems() {
        return mems;
    }

    public void setMems(List<Double> mems) {
        this.mems = mems;
    }

    public List<Double> getNetworks() {
        return networks;
    }

    public void setNetworks(List<Double> networks) {
        this.networks = networks;
    }

    public List<Integer> getStorage() {
        return storage;
    }

    public void setStorage(List<Integer> storage) {
        this.storage = storage;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
