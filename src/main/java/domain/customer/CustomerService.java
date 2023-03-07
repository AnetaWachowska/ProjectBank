package domain.customer;

import infrastructure.database.CustmerRepository;
import infrastructure.database.CustomerRepositoryInMemory;
import infrastructure.entity.Customer;

import java.util.List;
import java.util.UUID;

public class CustomerService {
    private final CustmerRepository customerRepository = new CustomerRepositoryInMemory();

    public Customer saveCustomer(String firstName, String lastName, Integer pinNumber, String mail) {
    return customerRepository.saveCustomer(new Customer(firstName,lastName, UUID.randomUUID().toString() //UUID samo generuje znaki
            ,pinNumber,mail));  //jeżeli mamy typ inny niż void to musi być return
    }
public void delateCustomer(Long id){
        customerRepository.deleteCustomer(id);
       // customerRepository.updateCustomer(id, "sss");
}

public List<Customer> getCustomers(){
        return customerRepository.getCustomers();
}

public Customer getCustomerById(Long id){
        return customerRepository.getCustomerById(id);
}
}
