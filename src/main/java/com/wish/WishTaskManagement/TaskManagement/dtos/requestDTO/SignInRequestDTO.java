package com.wish.WishTaskManagement.TaskManagement.dtos.requestDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class SignInRequestDTO {

    @NotNull(message = "Email is required")
    @Email(message = "Please provide a valid email")
    public String email;

    @NotNull(message = "Password is required")
    public String password;

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

}
