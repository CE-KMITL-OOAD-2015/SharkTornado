package th.ac.kmitl.ce.ooad;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;

/**
 * Created by Nut on 10/24/2015.
 */
public interface ReportRepository extends MongoRepository<Report, String> {
    //public Report findByDate(Date date);
}
