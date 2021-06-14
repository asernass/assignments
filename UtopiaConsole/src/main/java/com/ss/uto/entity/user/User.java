package com.ss.uto.entity.user;

public class User {
    private Integer id;
    private UserRole role;
    private String givenName;
    private String familyMame;
    private String username;
    private String email;
    private String password;
    private String phone;

    /**
     * Constructor for User
     * @param id
     * @param role
     * @param givenName
     * @param familyMame
     * @param username
     * @param email
     * @param password
     * @param phone
     */
    public User(Integer id, UserRole role, String givenName, String familyMame, String username, String email, String password, String phone) {
        this.id = id;
        this.role = role;
        this.givenName = givenName;
        this.familyMame = familyMame;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGivenName() {
        return givenName;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyMame() {
        return familyMame;
    }

    public void setFamilyMame(String familyMame) {
        this.familyMame = familyMame;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", roleId=" + role +
                ", givenName='" + givenName + '\'' +
                ", familyMame='" + familyMame + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
