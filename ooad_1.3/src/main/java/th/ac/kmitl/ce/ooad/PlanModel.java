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

    protected static Plan[] getPlan(Account user){
        return vmProvider.getInstance().getPlanByUser(user);
    }

    protected static Plan[] getAllUserPlan(Account user, String cloudProv){
        return vmProvider.getInstance().getPlanByCloudProv(user, cloudProv);
    }

    protected static Plan[] getAllPlan(Account user, String cloudProv){
        return vmProvider.getInstance().getPlanByCloudProv(user, cloudProv);
    }

    protected boolean updatePlan(Account user, String cloud, int plan) {
        Plan[] plans = getAllPlan(user, cloud);
        if(plan < plans.length){
            vmProvider.getInstance().changePlan(user, plans[plan]);
            return true;
        }
        return false;
    }
}
