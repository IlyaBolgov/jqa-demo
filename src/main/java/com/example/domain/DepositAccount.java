package com.example.domain;

public class DepositAccount extends AbstractAccount {

    public DepositAccount(double amount) {
        super(amount);
        if (amount < 0) throw new IllegalArgumentException("Amount must be positive");
    }

    public DepositAccount() {
        this(100.);
    }

    public static DepositAccount of(double amount) {
        return new DepositAccount(amount);
    }

    @Override
    public String toString() {
        return "Deposit" + super.toString();
    }

}
