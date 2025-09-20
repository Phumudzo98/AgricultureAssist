package com.agriculture.project.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class PestDisease {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String type;              // "Pest" or "Disease"
    private String name;              // e.g. Fall Armyworm, Late Blight
    private String severity;          // e.g. Low, Medium, High
    private LocalDate detectionDate;
    private String actionTaken;       // e.g. Sprayed pesticide, Pruned
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crop_id")
    private Crop crop;
}
