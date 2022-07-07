package com.example.demo.controllers;

import com.example.demo.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("vipAccounts", accountService.getVipAccountList());
        model.addAttribute("norVipNorDeletedAccounts", accountService.getNotVipAndNotDeletedAccountList());

        return "accounts";
    }


}
