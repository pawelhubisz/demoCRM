package com.example.demo.repository.Impl;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.AccountRepositoryCustom;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountRepositoryImpl implements AccountRepositoryCustom {


    @Override
    public List<Account> getAccountWithNoProfileList() {

        return null;
    }
}
