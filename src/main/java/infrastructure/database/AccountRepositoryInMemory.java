package infrastructure.database;

import infrastructure.entity.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AccountRepositoryInMemory implements AccountRepository {

    private final List<Account> accounts = new ArrayList<Account>();

    @Override
    public Account creatAccount(Account account) {
        return account;
    }

    @Override
    public void deactivateAccount(Long id) {
        findAccauntById(id).setActive(false);
    }

    @Override
    public Account getAccauntById(Long id) {
        return findAccauntById(id);
    }

    @Override
    public List<Account> getAccounts() {
        return accounts.stream()
                .filter(Account::isActive)
                .collect(Collectors.toList());
    }

    private Account findAccauntById(Long id) {
        Optional<Account> optionalAccaunt = accounts.stream()
                .filter(account -> account.getId().equals(id))
                .findFirst();
        return optionalAccaunt.orElseThrow(() -> new RuntimeException("No such customer"));
    }
}
