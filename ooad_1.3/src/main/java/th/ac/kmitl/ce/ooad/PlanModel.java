package th.ac.kmitl.ce.ooad;

/**
 * Created by Nut on 10/12/2015.
 */
public class PlanModel {
    private static PlanModel plan_controller = new PlanModel();
    private PlanModel(){

    }

    public static PlanModel getInstance(){
        return plan_controller;
    }

    protected static Plan[] getUserPlanByCloud(Account user, int cloudProv){
        CloudProvider cloudProvider;
        switch (cloudProv){
            case 0 : cloudProvider = CloudProvider.GOOGLE; break;
            case 1 : cloudProvider = CloudProvider.AMAZON; break;
            case 2 : cloudProvider = CloudProvider.AZURE; break;
            case 3 : cloudProvider = CloudProvider.DIGITAL_OCEAN; break;
            case 4 : cloudProvider = CloudProvider.VMWARE; break;
            default : cloudProvider = CloudProvider.UNKNOWN; break;
        }
        return vmProvider.getInstance().getPlanByCloudAccount(user.getCloudAccounts(cloudProvider));
    }

    protected static Plan[] getAllProviderPlan(int cloudProv) {
        CloudProvider cloudProvider;
        switch (cloudProv){
            case 0 : cloudProvider = CloudProvider.GOOGLE; break;
            case 1 : cloudProvider = CloudProvider.AMAZON; break;
            case 2 : cloudProvider = CloudProvider.AZURE; break;
            case 3 : cloudProvider = CloudProvider.DIGITAL_OCEAN; break;
            case 4 : cloudProvider = CloudProvider.VMWARE; break;
            default : cloudProvider = CloudProvider.UNKNOWN; break;
        }
        return vmProvider.getInstance().getPlanByCloudProv(cloudProvider);
    }

    protected boolean updatePlan(Account user, int cloudProv, int plan) {
        Plan[] plans = getAllProviderPlan(cloudProv);
        if(plan < plans.length){
            vmProvider.getInstance().changePlan(user, plans[plan]);
            return true;
        }
        return false;
    }
}
