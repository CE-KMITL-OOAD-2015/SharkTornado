package th.ac.kmitl.ce.ooad;

import java.util.List;

/**
 * Created by Nut on 11/3/2015.
 */
public class MonitoringModel {
    private static MonitoringModel monitoringModel = new MonitoringModel();
    private MonitoringModel(){

    }
    public MonitoringModel getInstance(){
        return monitoringModel;
    }
    protected void monitorUser(Account user){

    }
    protected boolean monitorUserClouds(Cloud[] clouds){
        return false;
    }
    protected boolean monitorUserVms(List<Vm> vms){
        return false;
    }
    private boolean isCpuOk(Vm vm, double cpu){
        if(cpu / vm.rCpu * 100 >= 90) return false;
        else return true;
    }
}
