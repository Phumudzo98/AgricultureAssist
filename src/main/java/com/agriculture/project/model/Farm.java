package com.agriculture.project.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String farmName;
    private String farm_type;
    private String farm_location;
    private String farm_description;
    private double size;
    private String metrics;
    private String city;


    @Column(columnDefinition = "bytea")
    private byte[] image;


    private String fileType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LandDetails> landDetails = new ArrayList<>();
}
