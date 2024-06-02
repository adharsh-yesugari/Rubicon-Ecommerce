package main.com.tadigital.ecommerce.customer.dao;

public interface CustomerSQL {
    String INSERT_CUSTOMER_INFO ="INSERT INTO customer_details(customer_firstName,customer_lastName,customer_emailId,customer_password) VALUES(?,?,?,?)";
    String SEARCH_CUSTOMER_BY_EMAIL_AND_PASSWORD = "SELECT customer_ID, customer_firstName, customer_lastName, customer_emailId,customer_password, customer_profilePicture  FROM customer_details WHERE customer_emailId =?  AND customer_password = ?";
    String SEARCH_CUSTOMER_BY_EMAIL = "SELECT customer_id, customer_firstName, customer_lastName, customer_emailID, customer_password,customer_profilePicture FROM customer_details WHERE customer_emailID = ?";
    String INSERT_CUSTOMER_ADDRESS_INFO ="INSERT INTO customer_details(address_line1,address_line2,address_line3,postalCode,city,state ,customer_emailId) VALUES(?,?,?,?,?,?,?,?)";
}
