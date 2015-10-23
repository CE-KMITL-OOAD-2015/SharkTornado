package th.ac.kmitl.ce.ooad.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import th.ac.kmitl.ce.ooad.Message.Message;

/**
 * Created by Nut on 10/23/2015.
 */
public interface MessageRepository extends MongoRepository<Message, String> {
}
