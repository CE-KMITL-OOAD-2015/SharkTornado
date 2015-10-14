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

}
