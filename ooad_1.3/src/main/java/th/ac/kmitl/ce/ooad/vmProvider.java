package th.ac.kmitl.ce.ooad;

/**
 * Created by Nut on 10/14/2015.
 */
public class vmProvider implements Provider {

    private static vmProvider vmprovider = new vmProvider();

    private vmProvider(){
    }

    public static vmProvider getInstance(){
        return vmprovider;
    }

    @Override
    public Cloud[] getClouds(Account user) {
        return new Cloud[0];
    }

//    @Override
//    public Plan[] getPlanByUser(Account user) {
//        return getPlanByCloudAccount(user.getCloudAccounts().get(0));
//    }

    @Override
    public Plan[] getPlanByCloudProv(CloudProvider provider) {
        Plan[] plans = new Plan[4];

        switch (provider) {
            case GOOGLE:
                plans[0] = new Plan(CloudProvider.GOOGLE, "0.0.0.0", (float)15.6, (float)2.4, (float)1.7, (float)300, 500);
                plans[1] = new Plan(CloudProvider.GOOGLE, "0.0.0.0", (float)16.6, (float)3.4, (float)2.7, (float)400, 600);
                plans[2] = new Plan(CloudProvider.GOOGLE, "0.0.0.0", (float)17.6, (float)4.4, (float)3.7, (float)500, 700);
                plans[3] = new Plan(CloudProvider.GOOGLE, "0.0.0.0", (float)18.6, (float)5.4, (float)4.7, (float)600, 800);
                break;

            case AMAZON:
                plans[0] = new Plan(CloudProvider.AMAZON, "0.0.0.0", (float)15.9, (float)4.2, (float)1.3, (float)200, 800);
                plans[1] = new Plan(CloudProvider.AMAZON, "0.0.0.0", (float)12.2, (float)1.4, (float)3.5, (float)800, 600);
                plans[2] = new Plan(CloudProvider.AMAZON, "0.0.0.0", (float)11.0, (float)2.4, (float)5.7, (float)900, 1000);
                plans[3] = new Plan(CloudProvider.AMAZON, "0.0.0.0", (float)18.9, (float)2.1, (float)2.5, (float)500, 900);
                break;

            case DIGITAL_OCEAN:
                plans[0] = new Plan(CloudProvider.DIGITAL_OCEAN, "0.0.0.0", (float)18.9, (float)2.8, (float)3.7, (float)400, 500);
                plans[1] = new Plan(CloudProvider.DIGITAL_OCEAN, "0.0.0.0", (float)19.2, (float)2.0, (float)2.5, (float)600, 400);
                plans[2] = new Plan(CloudProvider.DIGITAL_OCEAN, "0.0.0.0", (float)14.5, (float)3.4, (float)1.2, (float)400, 800);
                plans[3] = new Plan(CloudProvider.DIGITAL_OCEAN, "0.0.0.0", (float)19.9, (float)4.4, (float)5.7, (float)800, 1000);
                break;

            case AZURE:
                plans[0] = new Plan(CloudProvider.AZURE, "0.0.0.0", (float)12.6, (float)1.0, (float)1.7, (float)300, 500);
                plans[1] = new Plan(CloudProvider.AZURE, "0.0.0.0", (float)14.2, (float)3.7, (float)2.0, (float)500, 800);
                plans[2] = new Plan(CloudProvider.AZURE, "0.0.0.0", (float)15.3, (float)2.5, (float)2.7, (float)400, 600);
                plans[3] = new Plan(CloudProvider.AZURE, "0.0.0.0", (float)11.6, (float)3, (float)1.2, (float)500, 300);
                break;

            case VMWARE:
                plans[0] = new Plan(CloudProvider.VMWARE, "0.0.0.0", (float)9.9, (float)3.4, (float)1.5, (float)200, 600);
                plans[1] = new Plan(CloudProvider.VMWARE, "0.0.0.0", (float)12.5, (float)4.2, (float)5.2, (float)500, 1000);
                plans[2] = new Plan(CloudProvider.VMWARE, "0.0.0.0", (float)11.2, (float)1.2, (float)3.2, (float)400, 600);
                plans[3] = new Plan(CloudProvider.VMWARE, "0.0.0.0", (float)15.2, (float)5.1, (float)3.7, (float)500, 500);
                break;

            default:
                plans[0] = new Plan(CloudProvider.UNKNOWN, "0.0.0.0", 0, 0, 0, 0, 0);
                plans[1] = new Plan(CloudProvider.UNKNOWN, "0.0.0.0", 0, 0, 0, 0, 0);
                plans[2] = new Plan(CloudProvider.UNKNOWN, "0.0.0.0", 0, 0, 0, 0, 0);
                plans[3] = new Plan(CloudProvider.UNKNOWN, "0.0.0.0", 0, 0, 0, 0, 0);
        }

        return plans;
    }

    @Override
    public Plan[] getPlanByCloudAccount(CloudAccount cloudAccount) {
        return new Plan[0];
    }

    @Override
    public void changePlan(Account user, Plan newPlan) {

    }
}
