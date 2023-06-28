package com.task.management.api.controller;

import com.task.management.api.dto.CustomerRequest;
import com.task.management.api.dto.CustomerResponse;
import com.task.management.api.dto.LoginRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Validated
@Tag(name = "Customers API")
@RequestMapping("/api/task-management/public/v1/customers")
public interface CustomersApi {
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer successfully registered",
                    content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomerResponse.class))
            })
    })
    @RequestMapping(
            value = {"/sign-up"},
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.POST}
    )
    ResponseEntity<CustomerResponse> signUp(@Valid @RequestBody CustomerRequest requestModel);


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully logged in",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = String.class))
                    })
    })
    @RequestMapping(
            value = {"/login"},
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.POST}
    )
    ResponseEntity<String> login(@Valid @RequestBody  LoginRequest requestModel);
}
