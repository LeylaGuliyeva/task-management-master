package com.task.management.api.service.impl;

import com.task.management.api.dto.CustomerRegistrationDto;
import com.task.management.api.mapper.CustomerMapper;
import com.task.management.api.models.Customer;
import com.task.management.api.repository.CustomerRepository;
import com.task.management.api.service.EmailService;
import com.task.management.api.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final UserMapper userMapper;
    private final CustomerRepository customerRepo;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Customer createCustomer(CustomerRegistrationDto customerRegistrationDto) {
        Customer customer = dtoToEntity(customerRegistrationDto);
        return customerRepository.save(customer);
    }

    @Override
    public boolean customerExistsByEmail(String email) {
        return customerRepository.existsByEmail(email);
    }

    @Override
    public String getCustomerName(Customer customer) {
        return customer.getName().concat(" ").concat(customer.getSurname());
    }

    private Customer dtoToEntity(CustomerRegistrationDto customerRegistrationDto) {
        return customerMapper.CustomerFormToCustomer(customerRegistrationDto);
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
        String encodedPassword = passwordEncoder.encode(newPassword);
        customer.setPassword(encodedPassword);
        customerRepository.save(customer);
    }
}
