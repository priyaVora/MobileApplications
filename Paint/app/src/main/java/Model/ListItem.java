package Model;

/**
 * Created by Priya on 7/14/2018.
 */

public class ListItem {
    private String title;
    private String operationName;

    public ListItem(String title, String operationName) {
        this.title = title;
        this.operationName = operationName;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
