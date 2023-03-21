package infrastructure.entity;

import java.math.BigDecimal;

public class Account {

    private Long id;
    private BigDecimal amount; //kwota pieniędzy
    private Currency currency;
    private String accountNumber;
    private boolean active; // status konta archiwalny/czynny
    private Customer customer;
    private AccountType accountType;


    public Account( Currency currency, String accountNumber, Customer customer, AccountType accountType) {
        this.amount = BigDecimal.ZERO;
        this.currency = currency;
        this.active = true;
        this.customer = customer;
        this.accountType = accountType;
        this.accountNumber=accountNumber;
    }
}
