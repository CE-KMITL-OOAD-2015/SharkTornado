package th.ac.kmitl.ce.ooad;

import java.util.List;

/**
 * Created by Nut on 10/14/2015.
 */
public interface Provider {
    public List<Cloud> getClouds(Account user);
//    public Plan[] getPlanByUser(Account user);
    public List<Plan> getPlanByCloudAccount(CloudAccount cloudAccount);
    public Plan[] getPlanByCloudProv(CloudProvider provider);
    public void changePlan(Account user, Plan newPlan, CloudProvider cloudProvider, String ip);
    public Cloud getCloudStatus(Account user, CloudProvider cloudProvider);
    public Vm getVmStatus(Account user, String vmIP);
    public Plan getPlanByVM(CloudAccount cloudAccount, String vmIP);
    double getPrice(Plan plan);
}
