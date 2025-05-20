package com.GovernmentSchemes.user.dto;

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

    
    public UserResponseDto() {
    }

    public UserResponseDto(Long userId, String name, String email, String contact, String address, String typeOfUser, String image) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.typeOfUser = typeOfUser;
        this.image = image;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTypeOfUser() {
        return typeOfUser;
    }

    public void setTypeOfUser(String typeOfUser) {
        this.typeOfUser = typeOfUser;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
