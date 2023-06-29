package com.task.management.api.service.impl;

import com.task.management.api.dto.LoginRequest;
import com.task.management.api.entity.Customer;
import com.task.management.api.repository.CustomerRepository;
import com.task.management.api.service.CustomerService;
import com.task.management.api.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final EmailService emailService;
//    private final PasswordEncoder passwordEncoder;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public boolean customerExistsByEmail(String email) {
        return customerRepository.existsByEmail(email);
    }

    @Override
    public String customerExistsByLoginForm(LoginRequest requestModel) {
        Optional<Customer> customer = customerRepository.findByEmail(requestModel.getEmail());

        return customer.isPresent() && customer.get().getPassword().equals(requestModel.getPassword())
                ? "Successfully logged in"
                : "Check your input data";
    }

    @Override
    public String getCustomerName(Customer customer) {
        return customer.getName().concat(" ").concat(customer.getSurname());
    }

    @Override
    public void forgotPassword(String email) {
        if (customerRepository.existsByEmail(email)) {
            String newPassword = RandomString.make(30);
            emailService.sendEmail(email, newPassword);
            resetPassword(email, newPassword);
        } else {
            log.error("Customer with indicated email = {} doesn't exist", email);
        }
    }
    private void resetPassword(String email, String newPassword) {
        var customer = customerRepository.findByEmail(email).get();
//        String encodedPassword = passwordEncoder.encode(newPassword);
        customer.setPassword(newPassword);
        customerRepository.save(customer);
    }
}