package com.example.unit;

import com.example.domain.DepositAccount;
import com.example.exception.NotEnoughSpaceException;
import com.example.persist.MemoryAccountRepository;
import com.example.persist.ReportSaver;
import com.example.service.ReportService;
import com.example.utils.NumberedDecorator;
import com.example.utils.StringDecorator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ReportServiceTest {

    private MemoryAccountRepository accountRepository;
    private NumberedDecorator numDecorator;
    private ReportService sut;

    @BeforeEach
    public void setUpReportService() {
        accountRepository = new MemoryAccountRepository();
        numDecorator = new NumberedDecorator();

        var stubStringDecorator = mock(StringDecorator.class);
        when(stubStringDecorator.decorate(anyString()))
                .thenAnswer(param -> "2024-01-01" + param.getArgument(0));

        sut = new ReportService(
                accountRepository,
                numDecorator,
                stubStringDecorator
        );
    }

    @Test
    public void shouldGetReportWhenNoAccounts() {
        assertThat(sut.makeReport())
                .contains("");
    }

    @Test
    public void shouldGetReportWhenDepositAccountExist() throws NotEnoughSpaceException {
        accountRepository.addAccount(new DepositAccount(100.));
        assertThat(sut.makeReport())
                .contains("2024-01-01")
                .contains("Deposit")
                .contains("100.0");
    }

    @Test
    public void shouldSaveReportWhenDepositAccountExist() throws NotEnoughSpaceException {
        var mockSaver = mock(ReportSaver.class);

        sut = new ReportService(
                accountRepository,
                numDecorator,
                s -> s,
                mockSaver
        );

        accountRepository.addAccount(new DepositAccount(100.));
        sut.saveReport();
        verify(mockSaver, times(1))
                .save("0 Deposit, amount: 100.0\n");
    }
}
