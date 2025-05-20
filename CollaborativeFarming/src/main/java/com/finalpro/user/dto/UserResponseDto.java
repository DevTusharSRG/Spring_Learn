package com.finalpro.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private Long userId;       // ID of the user
    private String name;       // User's name
    private String email;      // User's email
    private String contact;    // User's contact number
    private String address;    // User's address
    private String typeOfUser; // Type of user (e.g., admin, customer, etc.)
    private String image;      // Image (if applicable)

}
