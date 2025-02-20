package com.example.service;

import com.example.domain.Account;
import com.example.domain.DepositAccount;
import com.example.exception.NotEnoughSpaceException;
import com.example.persist.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void addClient(double... amounts) throws NotEnoughSpaceException {
        for (double amount : amounts) {
            try {
                accountRepository.addAccount(new DepositAccount(amount));
            } catch (NotEnoughSpaceException e) {
                e.printStackTrace();
                throw e;
            }
        }
    }

    public void addAccount(Account account) throws NotEnoughSpaceException {
        try {
            accountRepository.addAccount(account);
        } catch (IllegalArgumentException | NotEnoughSpaceException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
