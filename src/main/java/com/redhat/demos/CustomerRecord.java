package com.redhat.demos;

public record CustomerRecord(String firstName, String lastName, String email, CustomerStatus customerStatus) {
}
