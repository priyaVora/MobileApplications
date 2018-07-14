package Model;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.example.priya.paint.R;

/**
 * Created by Priya on 7/14/2018.
 */


public class ListItem {
    public String title;
    public int photoId = R.drawable.colorchange;

    String[] operationsList = {"Color", "Brush", "Upload", "Clear", "Add+ 1", "Add+ 2", "Add+3"
            , "Add+ 4", "Add+ 5"};

    int[] photoIdList = {R.drawable.colorchange, R.drawable.brush_change,R.drawable.upload,R.drawable.clear, R.drawable.add,
            R.drawable.add,R.drawable.add,R.drawable.add,R.drawable.add};


    public ListItem(String title, int photoId) {
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