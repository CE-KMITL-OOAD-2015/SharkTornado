package th.ac.kmitl.ce.ooad;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Nut on 11/12/2015.
 */
public interface MessageRepository extends MongoRepository<Message, String>{
    List<Message> deleteByVm(String vm);
}
