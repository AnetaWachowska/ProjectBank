package domain.customer;

import infrastructure.database.CustmerRepository;
import infrastructure.database.CustomerRepositoryInMemory;
import infrastructure.entity.Customer;

public class CustomerService {
    private final CustmerRepository customerRepository = new CustomerRepositoryInMemory();

    public Customer saveCustomer(String firstName, String lastName, String numberIdCard, Integer pinNumber, String mail) {
    return customerRepository.saveCustomer(new Customer(firstName,lastName,numberIdCard,pinNumber,mail));  //jeżeli mamy typ inny niż void to musi być return
    }
public void delateCustomer(Long id){
        customerRepository.delateCustomer(id);
}
// utworzyc metody: updateCustomer (mam w paametrach przekazac ID,te elementy które chce update ,getCustomer, getCustomers

}
