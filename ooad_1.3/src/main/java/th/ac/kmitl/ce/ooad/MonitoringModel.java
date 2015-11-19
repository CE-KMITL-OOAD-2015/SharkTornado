package th.ac.kmitl.ce.ooad;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Nut on 11/3/2015.
 */
public class MonitoringModel {
    private static MonitoringModel monitoringModel = new MonitoringModel();
    private MonitoringModel(){

    }
    public static MonitoringModel getInstance(){
        return monitoringModel;
    }
    protected void monitorUser(Account user){

    }
    protected Cloud monitorCloud(CloudAccount cloudAccount){
        return vmProvider.getInstance().getCloudStatus(cloudAccount);
    }
    protected Vm monitorVm(CloudAccount cloudAccount, String vmIP){
        return vmProvider.getInstance().getVmStatus(cloudAccount, vmIP);
    }
    protected List<String> checkUserCloud(Account user) throws InterruptedException {
        List<String> rts = new ArrayList<>();
//        List<CloudAccount> cloudAccounts = user.getCloudAccounts();
        List<Cloud> clouds = vmProvider.getInstance().getClouds(user);

        for(Cloud cloud : clouds) {
            List<Vm> vms = cloud.getVms();

            for(Vm vm : vms) {
                if (!checkVmHealth(vm)) {
                    System.out.println("true");

                    rts.add(vm.vmIP + "," + vmProvider.getInstance()
                            .getPlanByVM(null, vm.vmIP).cloudProv.toString());
//                    System.out.println(vmProvider.getInstance()
//                            .getPlanByVM(null, vm.vmIP).cloudProv.toString());

                    Thread.sleep(500);
                }
            }
        }

        return rts;
    }
    protected boolean checkVmHealth(Vm vm) throws InterruptedException {
        System.out.println(vm.Cpu/vm.rCpu + ", " + vm.Mem/vm.rMem + ", "
                + vm.Network/vm.rNetwork + ", " + vm.Storage/vm.rStorage);

        if (vm.Cpu/vm.rCpu > 0.9)
            return false;

        if (vm.Mem/vm.rMem > 0.9)
            return false;

        if (vm.Network/vm.rNetwork >  0.9)
            return false;

        if (vm.Storage/vm.rStorage >  0.9)
            return false;

        return true;
    }

    protected void checkAllUserCloud() throws InterruptedException {
        List<Account> accounts = UserModel.getInstance().getAllAccount();
        for(Account account : accounts) {
            List<String> datas = checkUserCloud(account);
            for(String data : datas) {
                String[] splited_data = data.split(",");
                String cloudProv = splited_data[1];
                String vmIP = splited_data[0];
                MessageModel.getInstance().newMessage(CloudProvider.toEnum(cloudProv), vmIP, "Your one of resources has reach 90%", "High usage activity occur");
            }
        }
    }
    protected void checkVmReport(Vm vm){
        ReportModel.getInstance().putVmReports(vm.vmIP, Calendar.getInstance().getTime());
    }
    protected void checkAllVmReport(){
        //get allvmIP
        List<Vm> vms = new ArrayList<>();
        List<Account> accounts = UserModel.getInstance().getAllAccount();
        for(Account account : accounts){
            List<Cloud> clouds = vmProvider.getInstance().getClouds(account);
            for(Cloud cloud : clouds){
                List<Vm> temp_vms = cloud.getVms();
                for(Vm vm : temp_vms){
                    vms.add(vm);
                }
            }
        }
        for(Vm vm : vms){
            checkVmReport(vm);
        }
    }
    protected void run() throws InterruptedException {
        while(true) {
            for(int i = 0; i < 20; i++) System.out.println();
            System.out.println("Monitoring running");
            checkAllVmReport();
            checkAllUserCloud();
        }
    }
}
