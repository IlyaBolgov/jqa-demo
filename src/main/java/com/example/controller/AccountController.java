package com.example.controller;

import com.example.domain.DepositAccount;
import com.example.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * Endpoint to add an account.
     * Expects a POST request with a parameter 'amount'.
     */
    @PostMapping
    public ResponseEntity<String> addAccount(@RequestParam double amount) {
        try {
            accountService.addAccount(DepositAccount.of(amount));
            return ResponseEntity.ok("Account added successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
