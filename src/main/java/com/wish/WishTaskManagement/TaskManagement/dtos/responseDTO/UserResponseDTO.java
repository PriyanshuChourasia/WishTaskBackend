package com.wish.WishTaskManagement.TaskManagement.dtos.responseDTO;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wish.WishTaskManagement.TaskManagement.dtos.UserTypeDTO.UserTypeResponseDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponseDTO {

    private String id;

    private String name;

    private String email;

    @JsonProperty("username")
    private String username;

    @JsonProperty("profilePictureUrl")
    private String profilePictureUrl;

    private UserTypeResponseDTO userType;

    public UserResponseDTO(){}

    public UserResponseDTO(String id, String name, String email, String username, String profilePictureUrl, UserTypeResponseDTO userType){
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.profilePictureUrl = profilePictureUrl;
        this.userType = userType;
    }

    public UserResponseDTO(String id, String name, String email, String username, String profilePictureUrl){
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.profilePictureUrl = profilePictureUrl;
        this.userType = userType;
    }

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

    public UserTypeResponseDTO getUserType() {
        return userType;
    }

    public void setUserType(UserTypeResponseDTO userType) {
        this.userType = userType;
    }

}
