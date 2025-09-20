package com.agriculture.project.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class TaskActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String taskName;           // e.g. Irrigation, Fertilizer Application
    private String description;        // details of the task
    private LocalDate taskDate;
    private String status;             // Pending, Completed, In Progress
    private String assignedTo;         // worker/employee name

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "land_id")
    private LandDetails landDetails;
}
