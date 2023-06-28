package com.task.management.api.controller;

import com.task.management.api.adapter.WebAdapter;
import com.task.management.api.dto.CustomerRequest;
import com.task.management.api.dto.CustomerResponse;
import com.task.management.api.dto.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomersApiImpl implements CustomersApi {
    private final WebAdapter adapter;

    @Override
    public ResponseEntity<CustomerResponse> signUp(CustomerRequest requestModel) {
        return ResponseEntity.ok(null); // call adapter.map() methods to convert
        // requestModel to Entity, then from Entity to Response
    }

    @Override
    public ResponseEntity<String> login(LoginRequest requestModel) {
        return ResponseEntity.ok("Hello");
    }
}
