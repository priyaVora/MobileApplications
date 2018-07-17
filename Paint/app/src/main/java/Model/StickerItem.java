package Model;

import com.example.priya.paint.R;

/**
 * Created by Priya on 7/17/2018.
 */


public class StickerItem {
    public String title;
    public int photoId = R.drawable.colorchange;

    String[] operationsList = {"Go Back", "Add Text", "Clear", "Paint Fill", "Save"};

    //String[] operationsList = {"Go Back", "Text", "Change Background", "Save"};

    int[] photoIdList = {R.drawable.go_back, R.drawable.add_text,R.drawable.clear,R.drawable.paint_fill, R.drawable.save};


    public StickerItem(String title, int photoId) {
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
