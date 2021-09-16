package com.app.easy2excel.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ContactDTO {

    private Long id;

    private String firstName;

    private String lastName;

    @Email
    @NotEmpty(message = "email id is required")
    private String email;

    @Size(min=10,max=10,message = "phone no must be ten characters")
    @Pattern(regexp = "[0-9]+",message = "phone no must be numeric value")
    private String phoneNo;


}



