package com.task.management.api.service;

import com.task.management.api.dto.LoginRequest;
import com.task.management.api.entity.Customer;

public interface CustomerService {
    Customer createCustomer(Customer customerRegistrationDto);

    boolean customerExistsByEmail(String email);

    String customerExistsByLoginForm(LoginRequest requestModel);

    String getCustomerName(Customer customer);

    void forgotPassword(String email);
}