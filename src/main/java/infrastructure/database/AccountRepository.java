package infrastructure.database;

import infrastructure.entity.Account;

import java.util.List;

public interface AccountRepository {

Account creatAccount(Account account);
void deactivateAccount(Long id);
Account getAccauntById(Long id);
List <Account> getAccounts();
}
