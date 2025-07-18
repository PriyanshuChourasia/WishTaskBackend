package com.wish.WishTaskManagement.TaskManagement.dtos.responseDTO;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wish.WishTaskManagement.TaskManagement.dtos.UserTypeDTO.UserTypeResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.entities.UserType;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponseDTO {

    private String id;

    private String name;

    private String email;

    @JsonProperty("username")
    private String username;

    @JsonProperty("profilePictureUrl")
    private String profilePictureUrl;

    public UserTypeResponseDTO getUserType() {
        return userType;
    }

    public void setUserType(UserTypeResponseDTO userType) {
        this.userType = userType;
    }

    private UserTypeResponseDTO userType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }
}
