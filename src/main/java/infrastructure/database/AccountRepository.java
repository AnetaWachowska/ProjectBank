package infrastructure.database;

import infrastructure.entity.Account;
import infrastructure.entity.AccountType;
import infrastructure.entity.Currency;
import infrastructure.entity.Customer;

import java.math.BigDecimal;

public interface AccountRepository {

Account creatAccount(Account account);

}
