package com.agriculture.project.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String email;
    private String full_name;
    private String phone_number;
    private String address;
    private String city;
    private String province;
    private LocalDate createdAt;
}
