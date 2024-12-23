package com.example.tshust.service;

import com.example.tshust.dto.request.AccountCreationRequest;
import com.example.tshust.entity.Account;
import com.example.tshust.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Account creatAccount(AccountCreationRequest request) {
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        Account account = new Account();
        account.setEmail(request.getEmail());
        account.setUsername(request.getUsername());
        account.setPassword(encodedPassword);
        account.setPhoneNumber(request.getPhoneNumber());
        account.setRoleId(request.getRoleId());
        return accountRepository.save(account);
    }

    public List<Account> getAccount() {
        return accountRepository.findAll();
    }

    public Account loginAccount(String email, String rawPassword) {
        Optional<Account> accountOpt = accountRepository.findByEmail(email);

        if (accountOpt.isPresent()) {
            Account account = accountOpt.get();
            // Kiểm tra mật khẩu
            if (passwordEncoder.matches(rawPassword, account.getPassword())) {
                return account; // Đăng nhập thành công
            }
        }
        throw new RuntimeException("Invalid username or password");
    }
}