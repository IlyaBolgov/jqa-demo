package com.example.persist;

import com.example.domain.Account;
import com.example.exception.NotEnoughSpaceException;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    private final List<Account> accounts = new ArrayList<>();

    @Override
    public void addAccount(Account account) throws NotEnoughSpaceException {
        accounts.add(account);
    }

    @Override
    public int getAccountCount() {
        return accounts.size();
    }

    @Override
    public double getMeanAmount() {
        return accounts.stream().mapToDouble(Account::getAmount).average().orElse(0);
    }

    @Override
    public Collection<Account> getAccounts() {
        return new ArrayList<>(accounts);
    }
}

