package main.com.tadigital.ecommerce.customer.entity;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String oldPassword;
    private String newPassword;
    private String profilePicture;
    private int id;
    private String moobileNumber;


    public Customer() {
    }

    public Customer(String firstName, String lastName, String email, String password,  String profilePicture, int id, String moobileNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.setProfilePicture(profilePicture);
        this.setId(id);
        this.setMoobileNumber(moobileNumber);
    }

    public Customer(int id,String firstName, String lastName, String email, String password,  String profilePicture) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.setProfilePicture(profilePicture);
        this.setId(id);
    }


    public Customer( String firstName, String lastName, String email, String password ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
    public Customer( String email, String password ) {
        this.email = email;
        this.password = password;
    }

    public Customer( String email, String oldPassword, String newPassword ) {
        this.email = email;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;

    }
    public Customer( String email) {
        this.email = email;
    }

    public Customer(int id, String newPassword) {
        this.id = id;
        this.newPassword = newPassword;
    }

    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setEmail( String email ) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setPassword( String password ) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public String getOldPassword() {
        return oldPassword;
    }
    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
    public String getNewPassword() {
        return newPassword;
    }
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
    public String getProfilePicture() {
        return profilePicture;
    }
    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMoobileNumber() {
        return moobileNumber;
    }
    public void setMoobileNumber(String moobileNumber) {
        this.moobileNumber = moobileNumber;
    }

}
