package com.agriculture.project.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TaskActivityDto {
    private Long id;

    private String taskName;           // e.g. Irrigation, Fertilizer Application
    private String description;        // details of the task
    private LocalDate taskDate;
    private String status;             // Pending, Completed, In Progress
    private String assignedTo;
}
