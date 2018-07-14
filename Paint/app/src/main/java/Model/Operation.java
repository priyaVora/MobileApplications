package Model;

/**
 * Created by Priya on 7/14/2018.
 */

public class Operation {
    public String title;
    public int photoId;

    public Operation(String title, int photoId) {
        this.title = title;
        this.photoId = photoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }
}
