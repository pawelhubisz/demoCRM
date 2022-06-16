package com.example.demo.controllers;

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/accounts")
    public String getAllAccounts(Model model) {
        model.addAttribute("accounts", accountService.getAccountList());
        model.addAttribute("deletedAccounts", accountService.getDeletedAccountList());
        return "accounts";
    }


}
