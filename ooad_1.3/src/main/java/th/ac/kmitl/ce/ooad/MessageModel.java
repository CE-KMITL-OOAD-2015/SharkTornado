package th.ac.kmitl.ce.ooad;

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

    protected void setRepo(MessageRepository repo) {
        this.repo = repo;
    }

    protected void newMsgCallback(String userId, Message[] msgs){

    }

    protected void moveMessages(String userId){

    }
}
