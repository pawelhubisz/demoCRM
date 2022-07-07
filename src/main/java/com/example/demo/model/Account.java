package com.example.demo.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;
    private String name;
    private String login;
    private String email;
    public String title;
    public String author;


    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Profile> profileList;
    private boolean isDeleted;

    private boolean isVip;

    public Account() {
    }

    public Account(Long accountId, String name, String login, String email, boolean isDeleted, boolean isVip) {
        this.accountId = accountId;
        this.name = name;
        this.login = login;
        this.email = email;
        this.isDeleted = isDeleted;
        this.isVip = isVip;
    }

    public Account(String name, String login, String email, boolean isDeleted, boolean isVip) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.isDeleted = isDeleted;
        this.isVip = isVip;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    public List<Profile> getProfileList() {
        if (profileList == null) {
            profileList = new ArrayList<>();
        }
        return profileList;
    }

    public void setProfileList(List<Profile> profileList) {
        this.profileList = profileList;
    }
}
