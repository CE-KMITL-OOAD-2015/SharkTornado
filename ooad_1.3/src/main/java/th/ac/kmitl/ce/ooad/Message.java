package th.ac.kmitl.ce.ooad;

import org.springframework.data.annotation.Id;

/**
 * Created by Nut on 10/29/2015.
 */
public class Message {
    @Id String _id;
    CloudProvider cloudProvider;
    String vm;
    String topic;
    String detail;

    public Message(CloudProvider cloudProvider, String vm, String detail, String topic) {
        this.cloudProvider = cloudProvider;
        this.vm = vm;
        this.detail = detail;
        this.topic = topic;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
