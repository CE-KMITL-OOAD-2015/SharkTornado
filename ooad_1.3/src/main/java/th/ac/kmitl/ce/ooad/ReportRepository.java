package th.ac.kmitl.ce.ooad;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by Nut on 10/24/2015.
 */
public interface ReportRepository extends MongoRepository<Report, String> {
    public List<Report> findAll();
    public List<Report> findByvmIP(String vmIP);
}
