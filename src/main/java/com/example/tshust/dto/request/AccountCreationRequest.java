package com.example.tshust.dto.request;





public class AccountCreationRequest {
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private String roleId;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
