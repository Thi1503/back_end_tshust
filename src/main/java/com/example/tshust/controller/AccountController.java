package com.example.tshust.controller;

import com.example.tshust.dto.request.AccountCreationRequest;
import com.example.tshust.entity.Account;
import com.example.tshust.service.AccountService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping
    public Account createAccount(@RequestBody AccountCreationRequest request) {
        return accountService.creatAccount(request);
    }

    @GetMapping
    public List<Account> getAccounts() {
        return  accountService.getAccount();

    }

}
