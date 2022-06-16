package com.example.demo.controllers.rest;

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return new ResponseEntity("Account saved", HttpStatus.OK);
    }

    @GetMapping("/accountlist")
    public List<Account> getAccountList() {
        return accountService.getAccountList();
    }
}
