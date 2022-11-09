package com.redhat.demos;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class KafkaService {

    @Inject
    CustomerService customerService;

    @Incoming("customers-in")
    @Transactional
    public void addCustomer(CustomerRecord customerRecordToCreate) {

        Customer customer = customerService.createCustomer(customerRecordToCreate);
        System.out.println(customer);
    }
}
