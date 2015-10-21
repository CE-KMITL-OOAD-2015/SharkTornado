package th.ac.kmitl.ce.ooad;

import java.util.ArrayList;
import java.util.List;

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
        return vmProvider.getInstance().getPlanByCloudAccount(user.getCloudAccounts(CloudProvider.toEnum(cloudProv)));
    }

    protected static Plan[] getAllProviderPlan(int cloudProv) {
        return vmProvider.getInstance().getPlanByCloudProv(CloudProvider.toEnum(cloudProv));
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
