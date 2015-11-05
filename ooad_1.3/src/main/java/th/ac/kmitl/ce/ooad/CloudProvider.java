package th.ac.kmitl.ce.ooad;

import java.util.HashMap;

/**
 * Created by kohpai on 10/15/15.
 */
public enum CloudProvider {
    GOOGLE, AMAZON, AZURE, DIGITAL_OCEAN, VMWARE, UNKNOWN;

    private static HashMap<String, CloudProvider> map = new HashMap<>();
    public static CloudProvider toEnum (int cloudProv){
        CloudProvider cloudProvider;
        switch (cloudProv){
            case 0 : cloudProvider = CloudProvider.GOOGLE; break;
            case 1 : cloudProvider = CloudProvider.AMAZON; break;
            case 2 : cloudProvider = CloudProvider.AZURE; break;
            case 3 : cloudProvider = CloudProvider.DIGITAL_OCEAN; break;
            case 4 : cloudProvider = CloudProvider.VMWARE; break;
            default : cloudProvider = CloudProvider.UNKNOWN; break;
        }
        return cloudProvider;
    }

    public static CloudProvider toEnum (String cloudProv){
        return map.get(cloudProv);
    }

    public static void setCloudProviderString(String cloudProvString, CloudProvider cloudProvider){
        map.put(cloudProvString, cloudProvider);
    }
}
