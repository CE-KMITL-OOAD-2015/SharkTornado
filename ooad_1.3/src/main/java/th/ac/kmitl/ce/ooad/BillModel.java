package th.ac.kmitl.ce.ooad;

import java.util.List;

/**
 * Created by Nut on 10/24/2015.
 */
public class BillModel {
    private static BillModel billModel = new BillModel();
    private BillModel() {
    }

    public static BillModel getInstance(){
        return billModel;
    }

    protected Bill getBillByUser(Account user, String password){
        Bill bill = new Bill();
        if(UserModel.getInstance().authenUser(user.getUsername(), password)){
            List<Plan> plans = PlanModel.getInstance().getPlan(user, password);
            for(Plan plan : plans){
                bill.total += getPriceByPlan(plan);
            }
            bill.plans = plans;
        }
        return bill;
    }

    protected double getPriceByPlan(Plan plan){
        return vmProvider.getInstance().getPrice(plan);
    }

}
