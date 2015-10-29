package th.ac.kmitl.ce.ooad;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Nut on 10/29/2015.
 */
public interface MessageRepository extends MongoRepository<Message, String> {
    //public Message[] findByUserId(String userId);
}
