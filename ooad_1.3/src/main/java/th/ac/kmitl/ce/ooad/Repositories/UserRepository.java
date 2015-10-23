package th.ac.kmitl.ce.ooad.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import th.ac.kmitl.ce.ooad.User.Account;

/**
 * Created by Nut on 10/16/2015.
 */
public interface UserRepository extends MongoRepository<Account, String> {
    public Account findByUserId(String userId);
    public Account findByUsername(String username);
}
