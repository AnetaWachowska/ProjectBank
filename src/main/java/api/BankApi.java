package api;

import domain.customer.CustomerService;
import infrastructure.entity.Customer;

public class BankApi {
    private final CustomerService customerService = new CustomerService();

    public Customer saveCustomer(String firstName, String lastName, String numberIdCard, Integer pinNumber,
                                 String mail) {
        return customerService.saveCustomer(firstName, lastName, numberIdCard, pinNumber, mail);
    }

    public void delateCustomer(Long id) {
        customerService.delateCustomer(id);
    }
}

