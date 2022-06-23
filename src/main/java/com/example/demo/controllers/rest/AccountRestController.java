package com.example.demo.controllers.rest;

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AccountRestController {
    private AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/save")
    public ResponseEntity saveAccount() {
        Account account = new Account();
        account.setEmail("email");
        account.setName("name");
        account.setLogin("login");
        accountService.saveAccount(account);
        return new ResponseEntity("Account saved", HttpStatus.OK);
    }

    @GetMapping("/saveDeletedAccount")
    public ResponseEntity saveDeletedAccount() {
        Account deletedAccount = new Account();
        deletedAccount.setEmail("deletedemail");
        deletedAccount.setName("deletedname");
        deletedAccount.setLogin("deletedlogin");
        deletedAccount.setDeleted(true);
        accountService.saveAccount(deletedAccount);


        return new ResponseEntity("Deleted account saved", HttpStatus.OK);
    }
    @GetMapping("/saveVipAccount")
    public ResponseEntity saveVipAccount() {
        Account vipAccount = new Account();
        vipAccount.setEmail("vipemail");
        vipAccount.setName("vipname");
        vipAccount.setLogin("viplogin");
        vipAccount.setVip(true);
        accountService.saveAccount(vipAccount);


        return new ResponseEntity("Vip account saved", HttpStatus.OK);
    }

    @GetMapping("/accountlist")
    public List<Account> getAccountList() {
        return accountService.getAccountList();
    }

    @GetMapping("/createAccounts")
    public String createAccounts() {
        List<Account> createAccounts = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            createAccounts.add(new Account());
            createAccounts.add(new Account());
            createAccounts.add(new Account());
            createAccounts.add(new Account().setVip(true));
            createAccounts.add(new Account());
            createAccounts.add(new Account());
        }

        model.addAttribute("form", createAccounts);
        return "books/createBooksForm";
    }
}

