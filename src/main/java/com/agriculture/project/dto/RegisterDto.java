package com.agriculture.project.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String city;
    private String province;
    private String postalCode;
}
