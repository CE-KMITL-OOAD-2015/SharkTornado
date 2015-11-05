package th.ac.kmitl.ce.ooad;

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
    protected Cloud[] getDashboard(Account user, String password){
        if(UserModel.getInstance().authenUser(user.getUsername(), password)){
            Cloud[] clouds = vmProvider.getInstance().getClouds(user);
            Dashboard dashboard = new Dashboard(clouds);
            System.out.println(dashboard.toString());
            return clouds; //return
        }
        else return null;
    }

    protected Vm getVMStatus(Account user, String password, String vmIP){
        if(UserModel.getInstance().authenUser(user.getUsername(), password)){
            Vm vm = vmProvider.getInstance().getVmStatus(user, vmIP);
            return vm;
        }
        else return null;
    }
}
