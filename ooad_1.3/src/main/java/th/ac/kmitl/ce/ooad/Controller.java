package th.ac.kmitl.ce.ooad;

import org.springframework.web.bind.annotation.*;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import static java.util.Arrays.asList;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;

import javax.servlet.http.HttpServletResponse;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Sorts.ascending;
import static java.util.Arrays.asList;
/**
 * Created by Nut on 10/4/2015.
 */
@RestController
public class Controller {
    MongoClient mongodb = new MongoClient();
    MongoDatabase db = mongodb.getDatabase("Account");

    @RequestMapping("/addtest")
    public void addTest() throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
        db.getCollection("restaurants").insertOne(
                new Document("address",
                        new Document()
                                .append("street", "2 Avenue")
                                .append("zipcode", "10075")
                                .append("building", "1480")
                                .append("coord", asList(-73.9557413, 40.7720266)))
                        .append("borough", "Manhattan")
                        .append("cuisine", "Italian")
                        .append("grades", asList(
                                new Document()
                                        .append("date", format.parse("2014-10-01T00:00:00Z"))
                                        .append("grade", "A")
                                        .append("score", 11),
                                new Document()
                                        .append("date", format.parse("2014-01-16T00:00:00Z"))
                                        .append("grade", "B")
                                        .append("score", 17)))
                        .append("name", "Vella")
                        .append("restaurant_id", "41704620"));
    }

    @RequestMapping("viewtest")
    public String viewTest(){
        FindIterable<Document> iterable = db.getCollection("restaurants").find();
        final Document[] temp = new Document[1];
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document doc) {
                temp[0] = doc;
                System.out.println(doc);
            }
        });
        return temp[0].toJson();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/testuser")
    @ResponseBody
    public String testUser(HttpServletResponse response,@RequestBody Account user){
        Account temp = new Account(user);
        return "Added " + temp.getName();
    }
}
