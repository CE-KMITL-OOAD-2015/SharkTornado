package th.ac.kmitl.ce.ooad;

import org.springframework.data.mongodb.repository.MongoRepository;
import th.ac.kmitl.ce.ooad.Message;

/**
 * Created by Nut on 10/23/2015.
 */
public interface MessageRepository extends MongoRepository<Message, String> {
}
