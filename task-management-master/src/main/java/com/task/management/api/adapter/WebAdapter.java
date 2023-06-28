package com.task.management.api.adapter;


import com.task.management.api.dto.CustomerRequest;
import com.task.management.api.dto.CustomerResponse;
import com.task.management.api.dto.TaskRequest;
import com.task.management.api.dto.TaskResponse;
import com.task.management.api.entity.Customer;
import com.task.management.api.entity.Task;
import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(unmappedTargetPolicy = IGNORE, componentModel = "spring")
public interface WebAdapter {
    Customer map(CustomerRequest requestModel);

    CustomerResponse map(Customer entity);

    Task map(TaskRequest requestModel);

    TaskResponse map(Task entity);
}
