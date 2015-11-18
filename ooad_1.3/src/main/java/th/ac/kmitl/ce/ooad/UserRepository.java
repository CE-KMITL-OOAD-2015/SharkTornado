package th.ac.kmitl.ce.ooad;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Nut on 10/16/2015.
 */
public interface UserRepository extends MongoRepository<Account, String> {
    public Account findByUserId(String userId);
    public Account findByUsername(String username);
    public List<Account> findAll();
}
