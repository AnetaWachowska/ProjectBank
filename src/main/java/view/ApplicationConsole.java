package view;

import api.BankApi;

import java.util.Scanner;

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
                    "[2] - wyświetl użytkowników\n" +
                    "[3] - usuń użytkownika\n"
            );


            int choice = ScannerService.readInt();

            switch (choice) {
                case 1:
                    saveCustomer();
                    break;

                case 2:
                    getCustomers();
                    break;

                case 3:
                    delateCustomer();
                    break;

                case 4 :
                    getCustomerById();
                    break;
            
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
        System.out.println("nadaj pin:");
        int pinNumber = ScannerService.readInt();
        bankAPI.saveCustomer(fistname, password, pinNumber, email);
    }

    private void getCustomers() {
        System.out.println(bankAPI.getCustomers());
    }

    private void delateCustomer() {
        System.out.println("Podaj id usera");
        long id = ScannerService.readLong();
        bankAPI.delateCustomer(id);
    }

    private void getCustomerById(){
        System.out.println("podaj id ktorego chesz pokazac");
        long id = ScannerService.readLong();
        System.out.println(bankAPI.getCustomerById(id));
    }
}

