package com.example.persist;

import com.example.domain.Account;
import com.example.exception.NotEnoughSpaceException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

public class MemoryAccountRepository implements AccountRepository {
    public static final int MAX_ACCOUNTS = 10_000;
    public Collection<Account> accounts = new HashSet<>();

    public void addAccount(Account account) throws NotEnoughSpaceException {
        if (account == null) throw new IllegalArgumentException("Account must not be null");

        if (accounts.size() <= MAX_ACCOUNTS - 1) {
            accounts.add(account);
        } else {
            throw new NotEnoughSpaceException("Account repository is full");
        }
    }

    public int getAccountCount() {
        return accounts.size();
    }

    public double getMeanAmount() {
        var accountSum = accounts.stream()
                .filter(Objects::nonNull)
                .map(Account::getAmount)
                .reduce(Double::sum).orElse(0.);

        return accountSum / accounts.size();
    }

    public Collection<Account> getAccounts() {
        return Collections.unmodifiableCollection(accounts);
    }
}
