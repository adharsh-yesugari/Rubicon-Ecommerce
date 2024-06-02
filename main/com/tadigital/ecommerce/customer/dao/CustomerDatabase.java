package main.com.tadigital.ecommerce.customer.dao;

import main.com.tadigital.ecommerce.customer.entity.AddressDetails;
import main.com.tadigital.ecommerce.customer.entity.ContactDetailsUpdate;
import main.com.tadigital.ecommerce.customer.entity.Customer;
import main.com.tadigital.ecommerce.customer.entity.PersonalDetails;

public interface CustomerDatabase {
    public boolean insertCustomer(Customer customer);
    public Customer searchCustomerByEmailAndPassword(Customer customer);
    public Customer findCustomerByEmailId(Customer customer);
    public boolean updatePassword(Customer customer);
    public boolean customerPersonalUpdate(PersonalDetails personalDetails);
    public boolean contactDetailsUpdate(ContactDetailsUpdate contactDetailsUpdate);
    public boolean addressDetailsInsert(AddressDetails addressDetails);
    public String searchCustomerById(int customerID) ;
}
