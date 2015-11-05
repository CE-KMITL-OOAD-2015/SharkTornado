package th.ac.kmitl.ce.ooad;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    protected Plan[] getUserPlanByCloud(Account user, int cloudProv){
        return (Plan[]) vmProvider.getInstance().getPlanByCloudAccount(user.getCloudAccount(CloudProvider.toEnum(cloudProv))).toArray();
    }

    protected Plan[] getAllProviderPlan(String cloudProv) {
        return vmProvider.getInstance().getPlanByCloudProv(CloudProvider.toEnum(cloudProv));
    }

    protected List<Plan> getPlan(Account user, String password) {
        if(UserModel.getInstance().authenUser(user.getUsername(), password)) {
            List<CloudAccount> cloudAccountList = user.getCloudAccounts();
            ArrayList<Plan> plans = new ArrayList<Plan>();
            for (CloudAccount cloudAccount : cloudAccountList) {
                List<Plan> plans_tmp = vmProvider.getInstance().getPlanByCloudAccount(cloudAccount);
                plans.addAll(plans_tmp.stream().collect(Collectors.toList()));
            }
            return plans;
        }
        else return null;
    }

    protected Plan getVmPlan(Account user, String password, String vmIP, String cloudProv){
        if(UserModel.getInstance().authenUser(user.getUsername(), password)){
            Plan plan = vmProvider.getInstance().getPlanByVM(user.getCloudAccount(CloudProvider.toEnum(cloudProv)), vmIP);
            return plan;
        }
        return null;
    }

    protected boolean updatePlan(Account user, String cloudProv, int plan, String ip) {
        Plan[] plans = getAllProviderPlan(cloudProv);
        if(plan < plans.length){
            vmProvider.getInstance().changePlan(user, plans[plan], CloudProvider.toEnum(cloudProv), ip);
            return true;
        }
        return false;
    }
}
