package th.ac.kmitl.ce.ooad;

import th.ac.kmitl.ce.ooad.Vm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nut on 10/14/2015.
 */
public class Cloud {
    public String cloudName;
    private List<Vm> Vms;

    public Cloud(String cloudName, List<Vm> vms) {
        this.cloudName = cloudName;
        Vms = vms;
    }


    public List<Vm> getVms() {
        return Vms;
    }

    public void addVm(Vm vm) {
        Vms.add(vm);
    }

    public void setCloudName(String cloudName) {
        this.cloudName = cloudName;
    }

    public void setVms(List<Vm> vms) {
        Vms = vms;
    }

    public String toString(){

        return cloudName + Vms.toString() + "\n";
    }
}
