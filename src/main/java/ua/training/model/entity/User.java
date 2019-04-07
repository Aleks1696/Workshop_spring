package ua.training.model.entity;

import ua.training.model.types.UserRole;
import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String login;
    private String password;
    private UserRole role;
    private String name;
    private String name_ua;
    private String surname;
    private String surname_ua;
    private String email;
    private String phoneNumber;
    private List<Request> requests = new ArrayList<>();

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public UserRole getRole() {
        return role;
    }
    public void setRole(UserRole role) {
        this.role = role;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName_ua() {
        return name_ua;
    }
    public void setName_ua(String name_ua) {
        this.name_ua = name_ua;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getSurname_ua() {
        return surname_ua;
    }
    public void setSurname_ua(String surname_ua) {
        this.surname_ua = surname_ua;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public List<Request> getRequests() {
        return requests;
    }
    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }
}
