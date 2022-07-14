package com.example.demo.controllers;

import com.example.demo.model.Account;
import com.example.demo.model.Profile;
import com.example.demo.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UtilsController {
    private AccountService accountService;

    public UtilsController(AccountService accountService) {
        this.accountService = accountService;
    }
    @GetMapping("/status")
    public String applicationStatus() {
        return "UP";
    }

    @GetMapping("/setup")
    public String setUp() {
        accountService.saveAccount(new Account("name1", "login1", "email1", true, true));
        accountService.saveAccount(new Account("name2", "login2", "email2", true, true));
        accountService.saveAccount(new Account("name3", "login3", "email3", false, true));
        accountService.saveAccount(new Account("name4", "login4", "email4", false, true));
        accountService.saveAccount(new Account("name5", "login5", "email5", true, false));
        accountService.saveAccount(new Account("name6", "login6", "email6", true, false));
        accountService.saveAccount(new Account("name7", "login7", "email7", false, false));
        accountService.saveAccount(new Account("name8", "login8", "email8", false, false));
        Account account = new Account("name9", "login9", "email9", false, false);

        Profile profile = new Profile();
        profile.setName("profileName");
        profile.setAge(11);
        profile.setAccount(account);
        account.getProfileList().add(profile);

        accountService.saveAccount(account);
        return "Data saved";
    }


}


