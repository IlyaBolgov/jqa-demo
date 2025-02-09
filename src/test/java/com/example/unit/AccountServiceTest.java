package com.example.unit;

import com.example.domain.CreditAccount;
import com.example.domain.DepositAccount;
import com.example.exception.NotEnoughSpaceException;
import com.example.persist.MemoryAccountRepository;
import com.example.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AccountServiceTest {

    private MemoryAccountRepository accountRepository;
    private AccountService sut;

    @BeforeEach
    public void setUpAccountServiceAndRepository() {
        accountRepository = new MemoryAccountRepository();
        sut = new AccountService(accountRepository);
    }

    @Test
    public void shouldGetNoAccountCountWithoutAccounts() {
        assertThat(accountRepository.getAccountCount())
                .isEqualTo(0);
    }

    @Test
    public void shouldGetAccountCountWhenAccountAdded() throws NotEnoughSpaceException {
        sut.addAccount(new DepositAccount());
        assertThat(accountRepository.getAccountCount())
                .isEqualTo(1);
    }

    @Test
    public void shouldGetMeanAmountWhenTwoDepositAccountExist() throws NotEnoughSpaceException {
        sut.addAccount(new DepositAccount(100.));
        sut.addAccount(new DepositAccount(0.));
        assertThat(accountRepository.getMeanAmount())
                .isEqualTo(50.);
    }

    @Test
    public void shouldGetMeanAmountWhenTwoDifferentAccountsExist() throws NotEnoughSpaceException {
        sut.addAccount(new DepositAccount(100.));
        sut.addAccount(new CreditAccount(0.));
        assertThat(accountRepository.getMeanAmount())
                .isEqualTo(50.);
    }

    @Test
    public void shouldGetExceptionWhenAddNullAccount() {
        assertThatThrownBy(() -> sut.addAccount(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Account must not be null");
    }

    @Test
    public void shouldGetClientWithDepositAccountWhenClientAdded() throws NotEnoughSpaceException {
        sut.addClient(100.);

        assertThat(accountRepository.getAccounts())
                .contains(new DepositAccount(100.));
    }

    @Test
    public void shouldGetClientWithTwoDepositAccountsWhenTwoAccountsForClientAdded() throws NotEnoughSpaceException {
        sut.addClient(100., 50.);

        assertThat(accountRepository.getAccounts())
                .contains(new DepositAccount(100.), new DepositAccount(50.));
    }
}
