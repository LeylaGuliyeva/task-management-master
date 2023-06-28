package com.task.management.api.controller;

import com.task.management.api.dto.TaskRequest;
import com.task.management.api.dto.TaskResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Validated
@Tag(name = "Tasks API")
@RequestMapping("/api/task-management/public/v1/tasks")
public interface TaskApi {
    @Operation(summary = "Create task")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = TaskResponse.class))
                    })
    })
    @RequestMapping(
            value = {"/create"},
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.POST}
    )
    ResponseEntity<TaskResponse> createTask(@Valid @RequestBody  TaskRequest requestModel);


    @Operation(summary = "Update task by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = TaskResponse.class))
                    })
    })
    @RequestMapping(
            value = {"/{id}"},
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.PUT}
    )
    ResponseEntity<TaskResponse> updateTask(@PathVariable("id") Long taskId,
                                            @Valid @RequestBody  TaskRequest requestModel);


    @Operation(summary = "Update task's fields by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = TaskResponse.class))
                    })
    })
    @RequestMapping(
            value = {"/{id}"},
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.PATCH}
    )
    ResponseEntity<TaskResponse> updateTaskFields(@PathVariable("id") Long taskId,
                                                  @Valid @RequestBody  TaskRequest requestModel);


    @Operation(summary = "Delete task by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = String.class))
                    })
    })
    @RequestMapping(
            value = {"/{id}"},
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.DELETE}
    )
    ResponseEntity<String> deleteTask(@PathVariable("id") Long taskId);

    @Operation(summary = "Find Task by criteria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully found Task by criteria",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = TaskResponse.class))
                    })
    })
    @RequestMapping(
            value = {"/findAdvanced"},
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.POST}
    )
    ResponseEntity<TaskResponse> findAdvanced(@Valid @RequestBody TaskRequest requestModel);
}
