package domain.account;

import domain.customer.CustomerService;
import infrastructure.database.AccountRepository;
import infrastructure.entity.Account;
import infrastructure.entity.AccountType;
import infrastructure.entity.Currency;
import infrastructure.entity.Customer;

import java.util.Random;

public class AccountService {
    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final String CONTROL_NUMBER = "10";
    private final String BANK_ID = "2020";

    public AccountService(AccountRepository accountRepository, CustomerService customerService) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
    }

    public Account creatAccount(Currency currency,Long customerId, AccountType accountType) {
        var account = new Account(currency,generateAccountNumber(),
                customerService.getCustomerById(customerId),
                accountType);
        return accountRepository.creatAccount(account);
    }

    private String generateAccountNumber() {
        StringBuilder sb = new StringBuilder();
        sb.append(CONTROL_NUMBER);
        sb.append(BANK_ID);
        sb.append(generateRandomNumbers());
        return sb.toString();
    }

    private  String generateRandomNumbers() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(20);
        for (int i = 0; i < 20; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

}
