package io.arrogantprogrammer.demos;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/customers")
public class CustomerResource {

    @Inject
    CustomerService customerService;

    @GET
    public List<Customer> allCustomers() {
        return Customer.listAll();
    }

    @POST@Transactional
    public Customer addCustomer(CustomerRecord customerRecord) {

        return customerService.createCustomer(customerRecord);
    }
}
