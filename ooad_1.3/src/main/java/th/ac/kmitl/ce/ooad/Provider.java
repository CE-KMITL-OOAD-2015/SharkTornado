package th.ac.kmitl.ce.ooad;

import java.util.Date;
import java.util.List;

/**
 * Created by Nut on 10/14/2015.
 */
public interface Provider {
    public List<Cloud> getClouds(Account user);
//    public Plan[] getPlanByUser(Account user);
    public List<Plan> getPlanByCloudAccount(Account account, String cloudProv);
    public Plan[] getPlanByCloudProv(CloudProvider provider);
    public void changePlan(Account user, int newPlan, CloudProvider cloudProvider, String ip);
    public Cloud getCloudStatus(CloudAccount cloudAccount);

    public Vm getVmStatus(CloudAccount cloudAccount, String vmIP);
    public Plan getPlanByVM(CloudAccount cloudAccount, String vmIP);
    double getPrice(Plan plan);
    Report getVmReport(String vmIP, Date date);
}
