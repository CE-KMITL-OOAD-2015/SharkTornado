package th.ac.kmitl.ce.ooad;

/**
 * Created by Nut on 10/29/2015.
 */
public class Message {
    CloudProvider cloudProvider;
    String vm;
    String msg;

    public Message(CloudProvider cloudProvider, String vm, String msg) {
        this.cloudProvider = cloudProvider;
        this.vm = vm;
        this.msg = msg;
    }

    public Message() {
    }

    public CloudProvider getCloudProvider() {
        return cloudProvider;
    }

    public void setCloudProvider(CloudProvider cloudProvider) {
        this.cloudProvider = cloudProvider;
    }

    public String getVm() {
        return vm;
    }

    public void setVm(String vm) {
        this.vm = vm;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
