package th.ac.kmitl.ce.ooad;

import th.ac.kmitl.ce.ooad.Repositories.MessageRepository;

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
