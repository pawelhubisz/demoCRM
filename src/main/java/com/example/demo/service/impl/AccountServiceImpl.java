package com.example.demo.service.impl;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.AccountService;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void saveAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void saveDeletedAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public List<Account> getAccountList() {
        return Streamable.of(accountRepository.findAll()).toList();
    }

    @Override
    public List<Account> getDeletedAccountList() {
        List<Account> accountList = Streamable.of(accountRepository.findAll()).toList();
        List<Account> deletedAccountList = new ArrayList<>();
        for (Account account : accountList) {
            if (account.isDeleted()) {
                deletedAccountList.add(account);
            }
        }


        //return deletedAccountList;

        //return Streamable.of(accountRepository.findAll()).toList().stream().filter(account-> account.isDeleted()==true).toList();
        return Streamable.of(accountRepository.findAll()).toList().stream().filter(Account::isDeleted).toList();

    }

    @Override
    public List<Account> getVipAccountList() {
        List<Account> accountList = Streamable.of(accountRepository.findAll()).toList();
        List<Account> vipAccountList = new ArrayList<>();
        for (Account account : accountList) {
            if (account.isVip()) {
                vipAccountList.add(account);
            }
        }
        return Streamable.of(accountRepository.findAll()).toList().stream().filter(Account::isVip).toList();

    }

    @Override
    public List<Account> getNotVipAndNotDeletedAccountList() {
        List<Account> accountList = Streamable.of(accountRepository.findAll()).toList();
        List<Account> norVipNorDeletedAccountList = new ArrayList<>();
        for (Account account : accountList) {
            if (!(account.isVip() || account.isDeleted())) {
                norVipNorDeletedAccountList.add(account);
            }
        }
        //return Streamable.of(accountRepository.findAll()).toList().stream().filter(account-> !account.isDeleted()).toList();
        return Streamable.of(accountRepository.findAll()).toList().stream().filter(account -> !account.isVip()).toList().stream().filter(account -> !account.isDeleted()).toList();

    }

    @Override
    public List<Account> getAccountWithNoProfileList() {
        return Streamable.of(accountRepository.findAll()).toList().stream().filter(account -> account.getProfileList().size()>0).toList();
    }
}
