package main.com.tadigital.ecommerce.customer.service;

import main.com.tadigital.ecommerce.customer.dao.CustomerDatabase;
import main.com.tadigital.ecommerce.customer.dao.CustomerDatabaseImplementation;
import main.com.tadigital.ecommerce.customer.entity.AddressDetails;
import main.com.tadigital.ecommerce.customer.entity.ContactDetailsUpdate;
import main.com.tadigital.ecommerce.customer.entity.Customer;
import main.com.tadigital.ecommerce.customer.entity.PersonalDetails;

public class CustomerServiceImplementation implements CustomerService  {
    CustomerDatabase customerDatabase = new CustomerDatabaseImplementation();
    @Override
    public boolean registerCustomer(Customer customer) {
        return customerDatabase.insertCustomer(customer);
    }

    @Override
    public Customer loginCustomer(Customer customer) {
        return customerDatabase.searchCustomerByEmailAndPassword(customer);
    }

    @Override
    public boolean passwordUpdation(Customer customer) {
        return customerDatabase.updatePassword(customer);
    }

    @Override
    public boolean updatePersonalDetails(PersonalDetails personalDetails) {
        return customerDatabase.customerPersonalUpdate(personalDetails);
    }

    @Override
    public boolean contactDetailsUpdate(ContactDetailsUpdate contactDetailsUpdate) {
        return customerDatabase.contactDetailsUpdate(contactDetailsUpdate);
    }

    @Override
    public boolean addressDetailsInsert(AddressDetails addressDetails) {
        return customerDatabase.addressDetailsInsert(addressDetails);
    }

}
