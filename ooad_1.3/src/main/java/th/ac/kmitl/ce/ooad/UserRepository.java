package th.ac.kmitl.ce.ooad;

/**
 * Created by Nut on 10/12/2015.
 */

import java.util.UUID;

import com.mongodb.Block;
import com.mongodb.MongoClient;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;
public class UserRepository {
    MongoClient mongoClient;
    MongoDatabase db;
    private boolean exist = false;
    private String stemp = "";
    private Profile profile;
    public UserRepository(){
        mongoClient = new MongoClient();
        db = mongoClient.getDatabase("UserRepository");
    }

    public String addUser(Account newAccount){
        String userId = null;
        if(!isExist(newAccount.getUsername())){
            userId = UUID.randomUUID().toString();
            Document data = new Document("usrname", newAccount.getUsername())
                    .append("pwd", newAccount.getPassword())
                    .append("name", newAccount.getProfile().name)
                    .append("email", newAccount.getProfile().email)
                    .append("imgLoc", newAccount.getProfile().imgLoc)
                    .append("userId", userId);
            db.getCollection("Users").insertOne(data);
        }
        return userId;
    }

    public void updatePasswd(String userId, String passphrase){
        db.getCollection("Users").updateOne(eq("userId", userId), new Document("$set", new Document("pwd", passphrase)));
    }

    public void updateEmail(String userId, String email){
        db.getCollection("Users").updateOne(eq("userId", userId), new Document(("$set"), new Document("email", email)));
    }

    public void updateProImage(String userId, String imgLoc){
        db.getCollection("Users").updateOne(eq("userId", userId), new Document(("$set"), new Document("imgLoc", imgLoc)));
    }

    public void updateName(String userId, String name){
        db.getCollection("Users").updateOne(eq("userId", userId), new Document("$set", new Document("name", name)));
    }

    public String getUserIdByEmail(String email){

        return "username";
    }

    public String getUserById(String userId){
        String tmp = "";
        FindIterable<Document> cursor = db.getCollection("Users").find(new Document("userId", userId));
        cursor.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                if(document.containsValue(userId)) stemp = document.getString("usrname");
            }
        });
        tmp = stemp;
        stemp = "";
        return tmp;
    }

    public boolean isExist(String usrname){
        boolean tmp = false;
        FindIterable<Document> cursor = db.getCollection("Users").find(new Document("usrname", usrname));
        cursor.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                if(document.containsValue(usrname)) exist = true;
            }
        });
        tmp = exist;
        exist = false;
        return tmp;
    }

    public boolean isExistById(String userId){
        boolean tmp = false;
        FindIterable<Document> cursor = db.getCollection("Users").find(new Document("userId", userId));
        cursor.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                if(document.containsValue(userId)) exist = true;
            }
        });
        tmp = exist;
        exist = false;
        return tmp;
    }

    protected String getUserPass(String usrname){
        String tmp = "";
        FindIterable<Document> cursor = db.getCollection("Users").find(new Document("usrname", usrname));
        cursor.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                if(document.containsValue(usrname)) stemp = document.getString("pwd");
            }
        });
        tmp = stemp;
        stemp = "";
        return tmp;
    }

    protected Account getAccountById(String userId){
        FindIterable<Document> cursor = db.getCollection("Users").find(new Document("userId", userId));
        cursor.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                String email = document.getString("email");
                String name = document.getString("name");
                String imgLoc = document.getString("imgLoc");
                profile = new Profile(email, name, imgLoc);
            }
        });
        String username = getUserById(userId);
        String password = getUserPass(username);
        return new Account(profile, username, password, userId);
    }
}
