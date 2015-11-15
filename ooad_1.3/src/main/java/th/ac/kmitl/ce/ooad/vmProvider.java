package th.ac.kmitl.ce.ooad;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Nut on 10/14/2015.
 */
public class vmProvider implements Provider {

    private static vmProvider vmprovider = new vmProvider();
    private ArrayList<Plan> plans;

    private vmProvider(){
    }

    public static vmProvider getInstance(){
        return vmprovider;
    }

    @Override
    public List<Cloud> getClouds(Account user) {
        ArrayList<Vm> vms = new ArrayList<>();
        ArrayList<Cloud> clouds = new ArrayList<>();
        vms.add(new Vm("161.246.51.12", 100, 1.7, 300, 76, 1.29, 200, 500, 400));
        vms.add(new Vm("161.246.51.13", 100, 2.7, 400, 76, 2, 250, 600, 512));
        if(user.getCloudAccount(CloudProvider.GOOGLE) != null)
            clouds.add(new Cloud("GOOGLE", vms));
        //System.out.println(clouds[0].cloudName + " \n" + "Vm1 : " + clouds[0].getVms().get(0).vmIP + "\nVm2 : " + clouds[0].getVms().get(1).vmIP);
        vms = new ArrayList<>();
        vms.add(new Vm("68.69.70.11", 100, 1.3, 200, 22, 0.76, 124, 800, 795));
        if(user.getCloudAccount(CloudProvider.AMAZON) != null)
            clouds.add(new Cloud("AMAZON", vms));
        //System.out.println(clouds[1].cloudName + " \n" + "Vm1 : " + clouds[0].getVms().get(0).vmIP);
        vms = new ArrayList<>();
        vms.add(new Vm("69.69.69.69", 100, 3.7, 400, 53, 2.22, 333, 500, 111));
        if(user.getCloudAccount(CloudProvider.DIGITAL_OCEAN) != null)
            clouds.add(new Cloud("DIGITAL OCEAN", vms));
       // System.out.println(clouds[2].cloudName + " \n" + "Vm1 : " + clouds[0].getVms().get(0).vmIP);
        vms = new ArrayList<>();
        vms.add(new Vm("121.143.34.56", 100, 1.7, 300, 33, 1.2, 222, 500, 333));
        if(user.getCloudAccount(CloudProvider.AZURE) != null)
            clouds.add(new Cloud("AZURE", vms));
        //System.out.println(clouds[3].cloudName + " \n" + "Vm1 : " + clouds[0].getVms().get(0).vmIP);
        vms = new ArrayList<>();
        vms.add(new Vm("70.65.1.2", 100, 1.5, 200, 33, 1.2, 155, 600, 444));
        if(user.getCloudAccount(CloudProvider.AZURE) != null)
            clouds.add(new Cloud("VMWARE", vms));
        //System.out.println(clouds[4].cloudName + " \n" + "Vm1 : " + clouds[0].getVms().get(0).vmIP);
        return clouds;
    }

//    @Override
//    public Plan[] getPlanByUser(Account user) {
//        return getPlanByCloudAccount(user.getCloudAccounts().get(0));
//    }

    @Override
    public Plan[] getPlanByCloudProv(CloudProvider provider) {
        Plan[] plans = new Plan[4];

        switch (provider) {
            case GOOGLE:
                plans[0] = new Plan(CloudProvider.GOOGLE, "0.0.0.0", (float)15.6, (float)2.4, (float)1.7, (float)300, 500);
                plans[1] = new Plan(CloudProvider.GOOGLE, "0.0.0.0", (float)16.6, (float)3.4, (float)2.7, (float)400, 600);
                plans[2] = new Plan(CloudProvider.GOOGLE, "0.0.0.0", (float)17.6, (float)4.4, (float)3.7, (float)500, 700);
                plans[3] = new Plan(CloudProvider.GOOGLE, "0.0.0.0", (float)18.6, (float)5.4, (float)4.7, (float)600, 800);
                break;

            case AMAZON:
                plans[0] = new Plan(CloudProvider.AMAZON, "0.0.0.0", (float)15.9, (float)4.2, (float)1.3, (float)200, 800);
                plans[1] = new Plan(CloudProvider.AMAZON, "0.0.0.0", (float)12.2, (float)1.4, (float)3.5, (float)800, 600);
                plans[2] = new Plan(CloudProvider.AMAZON, "0.0.0.0", (float)11.0, (float)2.4, (float)5.7, (float)900, 1000);
                plans[3] = new Plan(CloudProvider.AMAZON, "0.0.0.0", (float)18.9, (float)2.1, (float)2.5, (float)500, 900);
                break;

            case DIGITAL_OCEAN:
                plans[0] = new Plan(CloudProvider.DIGITAL_OCEAN, "0.0.0.0", (float)18.9, (float)2.8, (float)3.7, (float)400, 500);
                plans[1] = new Plan(CloudProvider.DIGITAL_OCEAN, "0.0.0.0", (float)19.2, (float)2.0, (float)2.5, (float)600, 400);
                plans[2] = new Plan(CloudProvider.DIGITAL_OCEAN, "0.0.0.0", (float)14.5, (float)3.4, (float)1.2, (float)400, 800);
                plans[3] = new Plan(CloudProvider.DIGITAL_OCEAN, "0.0.0.0", (float)19.9, (float)4.4, (float)5.7, (float)800, 1000);
                break;

            case AZURE:
                plans[0] = new Plan(CloudProvider.AZURE, "0.0.0.0", (float)12.6, (float)1.0, (float)1.7, (float)300, 500);
                plans[1] = new Plan(CloudProvider.AZURE, "0.0.0.0", (float)14.2, (float)3.7, (float)2.0, (float)500, 800);
                plans[2] = new Plan(CloudProvider.AZURE, "0.0.0.0", (float)15.3, (float)2.5, (float)2.7, (float)400, 600);
                plans[3] = new Plan(CloudProvider.AZURE, "0.0.0.0", (float)11.6, (float)3, (float)1.2, (float)500, 300);
                break;

            case VMWARE:
                plans[0] = new Plan(CloudProvider.VMWARE, "0.0.0.0", (float)9.9, (float)3.4, (float)1.5, (float)200, 600);
                plans[1] = new Plan(CloudProvider.VMWARE, "0.0.0.0", (float)12.5, (float)4.2, (float)5.2, (float)500, 1000);
                plans[2] = new Plan(CloudProvider.VMWARE, "0.0.0.0", (float)11.2, (float)1.2, (float)3.2, (float)400, 600);
                plans[3] = new Plan(CloudProvider.VMWARE, "0.0.0.0", (float)15.2, (float)5.1, (float)3.7, (float)500, 500);
                break;

            default:
                plans[0] = new Plan(CloudProvider.UNKNOWN, "0.0.0.0", 0, 0, 0, 0, 0);
                plans[1] = new Plan(CloudProvider.UNKNOWN, "0.0.0.0", 0, 0, 0, 0, 0);
                plans[2] = new Plan(CloudProvider.UNKNOWN, "0.0.0.0", 0, 0, 0, 0, 0);
                plans[3] = new Plan(CloudProvider.UNKNOWN, "0.0.0.0", 0, 0, 0, 0, 0);
        }

        return plans;
    }

    @Override
    public List<Plan> getPlanByCloudAccount(CloudAccount cloudAccount) {
        plans = new ArrayList<Plan>();
        switch (cloudAccount.getCloudProv()) {
            case GOOGLE: {
                plans.add(new Plan(CloudProvider.GOOGLE, "161.246.51.12", 15.6f, 2.4f, 1.7f, 300.0f, 500));
                plans.add(new Plan(CloudProvider.GOOGLE, "161.246.51.13", 16.6f, 3.4f, 2.7f, 400.0f, 600));
//                plans.add(new Plan(CloudProvider.GOOGLE, "161.246.51.12", 17.6f, 4.4f, 3.7f, 500.0f, 700));
//                plans.add(new Plan(CloudProvider.GOOGLE, "161.246.51.12", 18.6f, 5.4f, 4.7f, 600.0f, 800));
                break;
            }
            case AMAZON: {
                plans.add(new Plan(CloudProvider.AMAZON, "68.69.70.11", 15.9f, 4.2f, 1.3f, 200.0f, 800));
//                plans.add(new Plan(CloudProvider.AMAZON, "68.69.70.11", 12.2f, 1.4f, 3.5f, 800.0f, 600));
//                plans.add(new Plan(CloudProvider.AMAZON, "68.69.70.11", 11.0f, 2.4f, 5.7f, 900.0f, 1000));
//                plans.add(new Plan(CloudProvider.AMAZON, "68.69.70.11", 18.9f, 2.1f, 2.5f, 500.0f, 900));
                break;
            }
            case DIGITAL_OCEAN: {
                plans.add(new Plan(CloudProvider.DIGITAL_OCEAN, "69.69.69.69", 18.9f, 2.8f, 3.7f, 400.0f, 500));
//                plans.add(new Plan(CloudProvider.DIGITAL_OCEAN, "69.69.69.69", 19.2f, 2.0f, 2.5f, 600.0f, 400));
//                plans.add(new Plan(CloudProvider.DIGITAL_OCEAN, "69.69.69.69", 14.5f, 3.4f, 1.2f, 400.0f, 800));
//                plans.add(new Plan(CloudProvider.DIGITAL_OCEAN, "69.69.69.69", 19.9f, 4.4f, 5.7f, 800.0f, 1000));
                break;
            }
            case AZURE: {
                plans.add(new Plan(CloudProvider.AZURE, "121.143.34.56", 12.6f, 1.0f, 1.7f, 300.0f, 500));
//                plans.add(new Plan(CloudProvider.AZURE, "121.143.34.56", 14.2f, 3.7f, 2.0f, 500.0f, 800));
//                plans.add(new Plan(CloudProvider.AZURE, "121.143.34.56", 15.3f, 2.5f, 2.7f, 400.0f, 600));
//                plans.add(new Plan(CloudProvider.AZURE, "121.143.34.56", 11.6f, 3.0f, 1.2f, 500.0f, 300));
                break;
            }
            case VMWARE: {
                plans.add(new Plan(CloudProvider.VMWARE, "70.65.1.2", 9.9f, 3.4f, 1.5f, 200.0f, 600));
//                plans.add(new Plan(CloudProvider.VMWARE, "70.65.1.2", 12.5f, 4.2f, 5.2f, 500.0f, 1000));
//                plans.add(new Plan(CloudProvider.VMWARE, "70.65.1.2", 11.2f, 1.2f, 3.2f, 400.0f, 600));
//                plans.add(new Plan(CloudProvider.VMWARE, "70.65.1.2", 15.2f, 5.1f, 3.7f, 500.0f, 500));
                break;
            }
            default: {
                plans.add(new Plan(CloudProvider.UNKNOWN, "0.0.0.0", 0.0f, 0.0f, 0.0f, 0.0f, 0));
//                plans.add(new Plan(CloudProvider.UNKNOWN, "0.0.0.0", 0.0f, 0.0f, 0.0f, 0.0f, 0));
//                plans.add(new Plan(CloudProvider.UNKNOWN, "0.0.0.0", 0.0f, 0.0f, 0.0f, 0.0f, 0));
//                plans.add(new Plan(CloudProvider.UNKNOWN, "0.0.0.0", 0.0f, 0.0f, 0.0f, 0.0f, 0));
            }
        }
        return plans;
    }

    @Override
    public void changePlan(Account user, Plan newPlan, CloudProvider cloudProvider, String ip) {
        for(Plan plan : plans){
            if(plan.ip.equals(ip)){
                plans.remove(plan);
                plans.add(newPlan);
            }
        }
    }

    @Override
    public Cloud getCloudStatus(CloudAccount cloudAccount) {
        return new Cloud(cloudAccount.toString(), null);
    }

    @Override
    public Vm getVmStatus(CloudAccount cloudAccount, String vmIP){
        double d = Math.random() * 1.7;
        int cpu = (int)Math.random()*100;
        int network = (int)Math.random()*300;
        int storage = (int)Math.random()*500;
        return new Vm(vmIP, 100, 1.7, 300, cpu, d, network, 500, storage);
    }

    @Override
    public Plan getPlanByVM(CloudAccount cloudAccount, String vmIP) {
        switch (cloudAccount.getCloudProv()) {
            case GOOGLE: {
                if(vmIP.equals("161.246.51.12")) return new Plan(CloudProvider.GOOGLE, "161.246.51.12", 15.6f, 2.4f, 1.7f, 300.0f, 500);
                else if(vmIP.equals("161.246.51.13")) return new Plan(CloudProvider.GOOGLE, "161.246.51.13", 16.6f, 3.4f, 2.7f, 400.0f, 600);
                break;
            }
            case AMAZON: {
                if(vmIP.equals("68.69.70.11")) return new Plan(CloudProvider.AMAZON, "68.69.70.11", 15.9f, 4.2f, 1.3f, 200.0f, 800);
                break;
            }
            case DIGITAL_OCEAN: {
                if(vmIP.equals("69.69.69.69")) return new Plan(CloudProvider.DIGITAL_OCEAN, "69.69.69.69", 18.9f, 2.8f, 3.7f, 400.0f, 500);
                break;
            }
            case AZURE: {
                if(vmIP.equals("121.143.34.56")) return new Plan(CloudProvider.AZURE, "121.143.34.56", 12.6f, 1.0f, 1.7f, 300.0f, 500);
                break;
            }
            case VMWARE: {
                if(vmIP.equals("70.65.1.2")) return new Plan(CloudProvider.VMWARE, "70.65.1.2", 9.9f, 3.4f, 1.5f, 200.0f, 600);
                break;
            }
            default: {
                return null;
            }
        }
        return null;
    }

    @Override
    public double getPrice(Plan plan) {
        return plan.monthlyRate;
    }

    @Override
    public Report getVmReport(String vmIP, Date date) {
        Report report = new Report("0.0.0.0", false);
        report.setTimestamp(new Date());
        return report;
    }

}
