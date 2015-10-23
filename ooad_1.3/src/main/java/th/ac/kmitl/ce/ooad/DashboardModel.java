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
    protected Dashboard getDashboard(Account user, String password){
        if(user.getPassword().equals(password)) {
            Cloud[] clouds = vmProvider.getInstance().getClouds(user);
            Dashboard dashboard = new Dashboard(clouds);
            return dashboard; //return
        }
        else return null;
    }
}
