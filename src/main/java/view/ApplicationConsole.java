package view;

import api.BankApi;

public class ApplicationConsole implements ApplicationView {
    private final BankApi bankAPI = new BankApi();

    @Override
    public void runApplication() {
        try {
            showMenu();
        } catch (Exception e) {
            e.printStackTrace();
            runApplication();
        }
    }

    private void showMenu() {
        boolean runApplication = true;
        while (runApplication) {
            System.out.println("Wybierz polecenie:\n" +
                    "[0] - wyjdź z programu\n" +
                    "[1] - utwórz konto użytkownika\n" +
                    "[2] - utwórz konto bankowe\n" +
                    "[3] - wyświetl wszytkich użytkowników\n" +
                    "[4] - wpłać pieniądze \n" +
                    "[5] - wypłać pieniądze \n" +
                    "[6] - przelej pieniądze \n" +
                    "[7] - pokaż historie \n" +
                    "[8] - pokaż w wybranej walucie");


            int choice = ScannerService.readInt();

            switch (choice) {
                case 1:
                    saveCustomer();
                    break;
            /*    case 2:
                    createAccount();
                    break;
                case 3:
                    printAllUsers();
                    break;
                case 4:
                    makeDeposit();
                    break;
                case 5:
                    makeWithdraw();
                    break;
                case 6:
                    makeTransfer();
                    break;
                case 7:
                    getHistory();
                    break;
                case 8:
                    exchangeCurrency(); */
                case 0:
                default:
                    runApplication = false;
                    break;
            }
        }
    }

    private void saveCustomer() {
        System.out.println("podaj imię użytkownika:");
        String fistname = ScannerService.readString();
        System.out.println("podaj hasło:");
        String password = ScannerService.readString();
        System.out.println("podaj email:");
        String email = ScannerService.readString();
        bankAPI.saveCustomer(fistname);
    }
/*
                private void createAccount() {
                    System.out.println("Podaj imię:");
                    String firstName = ScannerService.readString();
                    System.out.println("Podaj nazwisko:");
                    String lastName = ScannerService.readString();
                    System.out.println("Podaj numer karty: (9 znaków)");
                    String idCardNumber = ScannerService.readString();
                    System.out.println("Podaj ID użytkowanika:");
                    long userId = ScannerService.readLong();
                    System.out.println("Podaj PIN");
                    Integer pin = ScannerService.readInt();
                    System.out.println("Podaj typ konta:");
                    System.out.println("(0 - PERSONAL, 1 - BUSINESS, 2 - FOREIGN CURRENCY, 3 - SAVINGS)");
                    AccountType accountType = AccountType.values()[ScannerService.readInt()];
                    System.out.println("Podaj walute:");
                    System.out.println("(0 - PLN, 1 - USD, 2 - EUR)");
                    CurrencyType currencyType = CurrencyType.values()[ScannerService.readInt()];
                    bankAPI.createAccount(firstName, lastName, idCardNumber, userId, accountType, currencyType,pin);
                }

                private void printAllUsers() {
                    bankAPI.getAllUsers().stream()
                            .map(userView -> String.format("-> id: %d, login: %s, email: %s", userView.getId(),
                                    userView.getLogin(), userView.getEmail()))
                            .forEach(System.out::println);
                }

                private void makeDeposit() {
                    System.out.println("Podaj PIN");
                    Integer pin = ScannerService.readInt();
                    System.out.println("Podaj swój numer konta:");
                    String accountNumber = ScannerService.readString();
                    System.out.println("Podaj kwotę:");
                    String amount = ScannerService.readString();
                    System.out.println("Podaj walutę:");
                    String currency = ScannerService.readString();
                    bankAPI.deposit(amount, currency, accountNumber,pin);
                }

                private void makeWithdraw() {
                    System.out.println("Podaj PIN");
                    Integer pin = ScannerService.readInt();
                    System.out.println("Podaj swój numer konta:");
                    String accountNumber = ScannerService.readString();
                    System.out.println("Podaj kwotę:");
                    String amount = ScannerService.readString();
                    System.out.println("Podaj walutę:");
                    String currency = ScannerService.readString();
                    bankAPI.withdraw(amount, currency, accountNumber,pin);
                }

                private void makeTransfer() {
                    System.out.println("Podaj PIN");
                    Integer pin = ScannerService.readInt();
                    System.out.println("Podaj swój numer konta:");
                    String myAccountNumber = ScannerService.readString();
                    System.out.println("Podaj numer konta odbiorcy:");
                    String targetAccountNumber = ScannerService.readString();
                    System.out.println("Podaj kwotę:");
                    String amount = ScannerService.readString();
                    System.out.println("Podaj walutę:");
                    String currency = ScannerService.readString();
                    bankAPI.transfer(amount,currency,myAccountNumber,targetAccountNumber,pin);
                }

                private void getHistory() {
                    System.out.println("Podaj PIN");
                    Integer pin = ScannerService.readInt();
                    System.out.println("Podaj swój numer konta:");
                    String myAccountNumber = ScannerService.readString();
                    bankAPI.getHistory(myAccountNumber,pin);
                }

                private void exchangeCurrency() {
                    System.out.println("Podaj numer konta");
                    String myAccountNumber = ScannerService.readString();
                    System.out.println("Podaj walutę");
                    String currencyType = ScannerService.readString();
                    bankAPI.currencyExchangeWithProvision(myAccountNumber,currencyType);
                }
                */
}

