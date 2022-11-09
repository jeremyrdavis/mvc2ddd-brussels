package io.arrogantprogrammer.demos;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class KafkaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaService.class);

    @Inject
    CustomerService customerService;

    @Incoming("customers-in")
    @Transactional
    public void addCustomer(CustomerRecord customerRecordToCreate) {

        LOGGER.info("customer received: {}", customerRecordToCreate);
        Customer customer = customerService.createCustomer(customerRecordToCreate);
    }
}
