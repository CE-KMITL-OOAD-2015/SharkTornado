package th.ac.kmitl.ce.ooad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nut on 10/29/2015.
 */
public class MessageModel {
    private static MessageModel messageModel = new MessageModel();
    private MessageRepository repo;
    public MessageModel() {
    }

    public static MessageModel getInstance(){
        return messageModel;
    }

    protected void newMsgCallback(String userId, Message[] msgs){

    }

    protected void moveMessages(String userId){

    }

    protected void newMessage(CloudProvider cloudProvider, String vm, String detail, String topic){
        repo.save(new Message(cloudProvider, vm, detail, topic));
    }

    protected void setRepo(MessageRepository repo) {
        this.repo = repo;
    }

    //to check new message
    protected List<Message> checkMessage(String vmIP){
        return repo.deleteByVm(vmIP);
//        List<Message> messages = new ArrayList<>();
//        messages.add(new Message(CloudProvider.GOOGLE, vmIP, "11 this contains details. 11", "this is the topic of the message"));
//        messages.add(new Message(CloudProvider.GOOGLE, vmIP, "22 this contains details. 22", "this is the topic of the message"));
//        return messages;
    }
}
