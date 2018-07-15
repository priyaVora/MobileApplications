package Model;

import com.example.priya.paint.R;

/**
 * Created by Priya on 7/14/2018.
 */

public class ColorItem {
    public String title;
    public int photoId = R.drawable.colorchange;

    String[] operationsList = {"Pink", "Maroon", "Red", "Orange", "Yellow", "Green", "Dark Green", "Light Blue"
            , " Dark Blue", "Purple", "Black"};

    int[] photoIdList = {R.drawable.pink_circle, R.drawable.maroon_cicle,R.drawable.red_circle, R.drawable.orange_circle,R.drawable.yellow_circle, R.drawable.green_circle,
            R.drawable.dark_green_circle, R.drawable.blue_circle, R.drawable.dark_blue_circle, R.drawable.purple_circle, R.drawable.black_circle};


    public ColorItem(String title, int photoId) {
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

    public String[] getOperationsList() {
        return operationsList;
    }

    public String getSpecificTitle(int position) {
        return operationsList[position];
    }

    public void setOperationsList(String[] operationsList) {
        this.operationsList = operationsList;
    }

    public int[] getPhotoIdList() {
        return photoIdList;
    }

    public int getSpecificPhotoId(int position) {
        return photoIdList[position];
    }

    public void setPhotoIdList(int[] photoIdList) {
        this.photoIdList = photoIdList;
    }
}
