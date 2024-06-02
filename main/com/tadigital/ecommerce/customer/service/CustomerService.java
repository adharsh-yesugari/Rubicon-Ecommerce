package main.com.tadigital.ecommerce.customer.service;

import main.com.tadigital.ecommerce.customer.entity.AddressDetails;
import main.com.tadigital.ecommerce.customer.entity.ContactDetailsUpdate;
import main.com.tadigital.ecommerce.customer.entity.Customer;
import main.com.tadigital.ecommerce.customer.entity.PersonalDetails;

public interface CustomerService {
    public boolean registerCustomer(Customer customer);

    public Customer loginCustomer(Customer customer);

    public boolean passwordUpdation(Customer customer);

    public boolean updatePersonalDetails(PersonalDetails personalDetails);

    public boolean contactDetailsUpdate(ContactDetailsUpdate contactDetailsUpdate);

    public boolean addressDetailsInsert(AddressDetails addressDetails);
}