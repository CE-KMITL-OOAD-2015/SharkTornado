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
    protected static Dashboard getDashboard(Account user){
        Cloud[] clouds = vmProvider.getInstance().getClouds(user);
        Dashboard dashboard = new Dashboard(clouds);
        return dashboard; //return
    }
}
