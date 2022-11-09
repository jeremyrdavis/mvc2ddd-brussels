package com.redhat.demos;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CustomerService {

    @Inject
    CustomerRepository customerRepository;

    public Customer createCustomer(CustomerRecord customerRecord) {

        Customer customer = Customer.createCustomer(customerRecord.firstName(), customerRecord.lastName(), customerRecord.email());
        customerRepository.persist(customer);
        return customer;
    }
}
