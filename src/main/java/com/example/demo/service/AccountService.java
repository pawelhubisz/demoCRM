package com.example.demo.service;

import com.example.demo.model.Account;

import java.util.List;

public interface AccountService {
    void saveAccount(Account account);

    void saveDeletedAccount(Account account);

    List<Account> getAccountList();

    List<Account> getDeletedAccountList();

    List<Account> getVipAccountList();

    List<Account> getNotVipAndNotDeletedAccountList();

}
