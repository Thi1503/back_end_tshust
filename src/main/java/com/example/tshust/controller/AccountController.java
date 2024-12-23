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
import java.util.Map;


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
            // Gọi service để xác thực thông tin đăng nhập
            Account account = accountService.loginAccount(request.getEmail(), request.getPassword());

            // Trả về JSON với thông tin chi tiết
            return ResponseEntity.ok(Map.of(
                    "status", "success",
                    "message", "Login successful",
                    "user", Map.of(
                            "id", account.getAccountId(),
                            "username", account.getUsername(),
                            "email", account.getEmail()
                    )
            ));
        } catch (RuntimeException e) {
            // Trả về lỗi nếu thông tin đăng nhập không chính xác
            return ResponseEntity.status(401).body(Map.of(
                    "status", "error",
                    "message", e.getMessage()
            ));
        }
    }




}