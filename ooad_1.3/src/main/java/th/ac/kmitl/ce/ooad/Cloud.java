package th.ac.kmitl.ce.ooad;

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
        Vms = new ArrayList<>();
    }


    public List<Vm> getVms() {
        return Vms;
    }

    public void addVm(Vm vm) {
        Vms.add(vm);
    }
}
