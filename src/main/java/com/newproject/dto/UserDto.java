package com.newproject.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserDto {

    private String firstName;

    private String lastName;

    private Long tcNo;

    private Integer yas;
}
