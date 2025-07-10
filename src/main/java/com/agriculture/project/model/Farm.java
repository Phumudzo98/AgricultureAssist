package com.agriculture.project.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Byte image;


    @ManyToOne
    private User user;
}
