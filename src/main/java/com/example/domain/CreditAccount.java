package com.example.domain;

public class CreditAccount extends AbstractAccount {

    public CreditAccount(double amount) {
        super(amount);
    }

    public CreditAccount() {
        this(100.);
    }

    public static CreditAccount of(double amount) {
        return new CreditAccount(amount);
    }

    @Override
    public String toString() {
        return "Credit" + super.toString();
    }
}
