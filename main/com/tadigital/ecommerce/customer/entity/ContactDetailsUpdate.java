package main.com.tadigital.ecommerce.customer.entity;

public class ContactDetailsUpdate {
    private int ID;
    private String email;
    private String mobileNumber;

    public ContactDetailsUpdate() {

    }

    public ContactDetailsUpdate(String email, String mobileNumber ) {
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}

