package th.ac.kmitl.ce.ooad;

import java.util.List;

/**
 * Created by Nut on 10/23/2015.
 */
public class DashboardModel {
    private static DashboardModel dashboardModel = new DashboardModel();
    private DashboardModel(){

    }
    public static DashboardModel getInstance(){
        return dashboardModel;
    }
    protected List<Cloud> getDashboard(Account user, String password){
        if(UserModel.getInstance().authenUser(user.getUsername(), password)){
            List<Cloud> clouds = vmProvider.getInstance().getClouds(user);
            //Dashboard dashboard = new Dashboard(clouds);
            //System.out.println(dashboard.toString());
            return clouds; //return
        }
        else return null;
    }

    protected Vm getVMStatus(Account user, String password, String cloudProv, String vmIP){
        if(UserModel.getInstance().authenUser(user.getUsername(), password)){
            return vmProvider.getInstance().getVmStatus(user.getCloudAccount(CloudProvider.toEnum(cloudProv)), vmIP);
        }
        else return null;
    }
}
