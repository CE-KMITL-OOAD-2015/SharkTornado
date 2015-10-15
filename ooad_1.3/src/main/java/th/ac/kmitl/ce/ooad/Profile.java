package th.ac.kmitl.ce.ooad;

/**
 * Created by Nut on 10/12/2015.
 */
public class Profile {
    public String email, name, imgLoc;

    public Profile(String email, String name, String imgLoc) {
        this.email = email;
        this.name = name;
        this.imgLoc = imgLoc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgLoc() {
        return imgLoc;
    }

    public void setImgLoc(String imgLoc) {
        this.imgLoc = imgLoc;
    }

    public String toString(){
        return String.format("Name=%s, email=%s, imgLocation=%s", name, email, imgLoc);
    }
}
