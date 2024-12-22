package com.example.tshust.service;

import com.example.tshust.dto.request.AccountCreationRequest;
import com.example.tshust.entity.Account;
import com.example.tshust.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account creatAccount(AccountCreationRequest request) {
        Account account = new Account();
        account.setEmail(request.getEmail());
        account.setUsername(request.getUsername());
        account.setPassword(request.getPassword());
        account.setPhoneNumber(request.getPhoneNumber());
        account.setRoleId(request.getRoleId());
        return accountRepository.save(account);
    }

    public List<Account> getAccount() {
        return accountRepository.findAll();
    }
}
