package com.wish.WishTaskManagement.TaskManagement.dtos.requestDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class UserRequestDTO {

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @NotNull(message = "Name is required")
    private String name;

    @NotNull(message = "Email is required")
    @Email(message = "Invalid Email")
    private String email;

    @NotNull(message = "Password is required")
    private String password;



    private String userType;
}
