package th.ac.kmitl.ce.ooad;

import org.springframework.data.mongodb.repository.MongoRepository;
import th.ac.kmitl.ce.ooad.Report;

import java.util.Date;

/**
 * Created by Nut on 10/23/2015.
 */
public interface ReportRepository extends MongoRepository<Report, String>{
    public Report[] findByDate(Date date);
}
