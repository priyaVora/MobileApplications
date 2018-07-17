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

    String[] operationsList = {"Color", "Brush", "Upload","Clear","Erase", "Text", "Paint Fill", "Save"
            , "Shapes"};

    int[] photoIdList = {R.drawable.colorchange, R.drawable.brush_change,R.drawable.upload,R.drawable.clear, R.drawable.erase,
            R.drawable.text,R.drawable.paint_fill,R.drawable.save,R.drawable.shapes};


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
