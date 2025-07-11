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

    private String email;
    private String password;
    private String full_name;
    private String phone_number;
    private String address;
    private String city;
    private String province;
}
