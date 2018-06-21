package Model;

/**
 * Created by Priya on 6/19/2018.
 */

public class Contact {
    private int id;
    private String name;
    private String phoneNumber;


    public Contact() {

    }
    public Contact(int id, String name,String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.id = id;
        this.name = name;
    }

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
