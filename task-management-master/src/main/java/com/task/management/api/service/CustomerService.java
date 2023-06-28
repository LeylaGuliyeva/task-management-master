package com.task.management.api.service;

public interface CustomerService {
    Customer createCustomer(CustomerRegistrationDto customerRegistrationDto);

    boolean customerExistsByEmail(String email);

    String getCustomerName(Customer customer);

    void forgotPassword(String email);

