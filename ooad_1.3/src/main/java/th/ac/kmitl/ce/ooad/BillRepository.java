package th.ac.kmitl.ce.ooad;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Nut on 10/30/2015.
 */
public interface BillRepository extends MongoRepository<Bill, String> {
    public Bill findByUserId(String userId);
}
