package com.example.utils;

import com.example.domain.Account;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;

@Component
public class NumberedDecorator {
    public String[] decorate(Collection<Account> accounts) {
        return IntStream.range(0, accounts.size())
                .mapToObj(i -> i + " " + accounts.toArray(new Account[0])[i])
                .toArray(String[]::new);
    }
}
