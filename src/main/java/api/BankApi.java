package api;

import domain.customer.CustomerService;
import infrastructure.entity.Customer;

import java.util.List;

public class BankApi {
    private final CustomerService customerService = new CustomerService();

    public Customer saveCustomer(String firstName, String lastName, Integer pinNumber,
                                 String email) {
        return customerService.saveCustomer(firstName, lastName, pinNumber, email);
    }

    public void delateCustomer(Long id) {
        customerService.delateCustomer(id);
    }

    public List<Customer>getCustomers(){
       return customerService.getCustomers();
    }
    public Customer getCustomerById(Long id){
        return customerService.getCustomerById(id);
    }

    public Customer updateCustomer(Long id,Integer pinNumber, String mail){
        return customerService.updateCustomer(id,pinNumber, mail);
    }

    // TODO: 2023-04-04 wystawić wszystkie metody z service w bank API 
}

