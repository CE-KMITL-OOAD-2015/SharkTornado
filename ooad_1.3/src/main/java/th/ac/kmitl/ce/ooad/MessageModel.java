package th.ac.kmitl.ce.ooad;

/**
 * Created by Nut on 10/23/2015.
 */
public class MessageModel {
    private static MessageModel messageModel;
    private MessageRepository messageRepository;

    public static MessageModel getInstance() {
        return messageModel;
    }

    public void setMessageRepository(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
}
