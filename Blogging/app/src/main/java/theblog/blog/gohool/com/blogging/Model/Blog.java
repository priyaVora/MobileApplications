package theblog.blog.gohool.com.blogging.Model;

/**
 * Created by Priya on 8/8/2018.
 */

public class Blog {
    public String title;
    public String desc;
    public String image;
    public String timestamp;
    public String userid;

    public Blog() {

    }

    public Blog(String title, String desc, String image, String timestamp, String userId) {
        this.title = title;
        this.desc = desc;
        this.image = image;
        this.timestamp = timestamp;
        this.userid = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return desc;
    }

    public void setDescription(String description) {
        this.desc = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userId) {
        this.userid = userId;
    }
}
