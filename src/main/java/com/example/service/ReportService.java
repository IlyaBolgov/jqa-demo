package com.example.service;

import com.example.domain.Account;
import com.example.persist.AccountRepository;
import com.example.persist.ReportSaver;
import com.example.utils.NumberedDecorator;
import com.example.utils.StringDecorator;
import java.util.Collection;

public class ReportService {
    private final AccountRepository accountRepository;
    private final NumberedDecorator numberedDecorator;
    private final StringDecorator stringDecorator;
    private ReportSaver saver;

    public ReportService(AccountRepository accountRepository, NumberedDecorator numberedDecorator, StringDecorator stringDecorator) {
        this.accountRepository = accountRepository;
        this.numberedDecorator = numberedDecorator;
        this.stringDecorator = stringDecorator;
    }

    public ReportService(AccountRepository accountRepository, NumberedDecorator numberedDecorator, StringDecorator stringDecorator, ReportSaver saver) {
        this.accountRepository = accountRepository;
        this.numberedDecorator = numberedDecorator;
        this.stringDecorator = stringDecorator;
        this.saver = saver;
    }

    public String makeReport() {

        StringBuilder report = new StringBuilder();
        Collection<Account> accounts = accountRepository.getAccounts();
        String[] numberedAccounts = numberedDecorator.decorate(accounts);

        for (String account : numberedAccounts) {
            if (account == null) break;
            report.append(stringDecorator.decorate(account)).append("\n");
        }

        return report.toString();
    }

    public void saveReport() {
        saver.save(makeReport());
    }
}