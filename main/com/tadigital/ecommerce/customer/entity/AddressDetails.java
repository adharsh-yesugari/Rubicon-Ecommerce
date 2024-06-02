package main.com.tadigital.ecommerce.customer.entity;

public class AddressDetails {
    private int addressID;
    private int customerID;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String postalCode;
    private String state;
    private String city;

    public AddressDetails() {

    }

    public AddressDetails(int addressID, String addressLine1, String addressLine2, String addressLine3, String postalCode,
                          String state, String city) {
        this.addressID = addressID;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.postalCode = postalCode;
        this.state = state;
        this.city = city;
    }


    public AddressDetails(String addressLine1, String addressLine2, String addressLine3, String postalCode,
                          String state, String city) {

        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.postalCode = postalCode;
        this.state = state;
        this.city = city;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

}

