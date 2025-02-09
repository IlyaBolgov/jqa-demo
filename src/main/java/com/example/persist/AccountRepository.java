package com.example.persist;

import com.example.domain.Account;
import com.example.exception.NotEnoughSpaceException;
import java.util.Collection;

public interface AccountRepository {
    void addAccount(Account account) throws NotEnoughSpaceException;
    int getAccountCount();
    double getMeanAmount();
    Collection<Account> getAccounts();
}
