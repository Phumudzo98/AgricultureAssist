package com.agriculture.project.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String farm_name;
    private String farm_type;
    private String farm_location;
    private String farm_description;
    private double size;
    private String metrics;

    @Lob
    private byte[] image;

    @ManyToOne
    private User user;

    @OneToMany
    private List<LandDetails> landDetails;
}
