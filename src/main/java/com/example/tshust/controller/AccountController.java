package com.example.tshust.controller;

import com.example.tshust.dto.request.AccountCreationRequest;
import com.example.tshust.dto.request.AccountLoginRequest;
import com.example.tshust.entity.Account;
import com.example.tshust.service.AccountService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AccountLoginRequest request) {
        try {
            Account account = accountService.loginAccount(request.getEmail(), request.getPassword());
            return ResponseEntity.ok("Login successful for user: " + account.getUsername());
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }



}