package com.redhat.demos;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Customer extends PanacheEntity {

    String firstName;

    String lastName;

    String email;

    CustomerStatus customerStatus;

    public Customer() {
    }

    public static Customer createCustomer(String firstName, String lastName, String email) {

        Customer customer = new Customer();
        customer.firstName = firstName;
        customer.lastName = lastName;
        customer.email = email;

        if(firstName.equals("Jay")){
            customer.customerStatus = CustomerStatus.PLATINUM;
        } else if (firstName.equals("Jeremy")) {
            customer.customerStatus = CustomerStatus.GOLD;
        }

        return customer;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public CustomerStatus getCustomerStatus() {
        return customerStatus;
    }
}
