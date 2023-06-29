package com.task.management.api.controller;

import com.task.management.api.adapter.WebAdapter;
import com.task.management.api.dto.CustomerRequest;
import com.task.management.api.dto.CustomerResponse;
import com.task.management.api.dto.LoginRequest;
import com.task.management.api.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomersApiImpl implements CustomersApi {
    private final WebAdapter adapter;
    private final CustomerService service;

    @Override
    public ResponseEntity<CustomerResponse> signUp(CustomerRequest requestModel) {
        return ResponseEntity.ok(adapter.map(service.createCustomer(adapter.map(requestModel))));
    }

    @Override
    public ResponseEntity<String> login(LoginRequest requestModel) {
        return ResponseEntity.ok(service.customerExistsByLoginForm(requestModel));
    }
}