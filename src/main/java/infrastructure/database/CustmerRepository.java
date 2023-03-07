package infrastructure.database;

import infrastructure.entity.Customer;

import java.util.List;

public interface CustmerRepository { //byt który po zaimplementowaniu go w klasie narzuca zaimplementowanie ciała metod
   Customer saveCustomer(Customer customer);
   void deleteCustomer(Long id);
   List<Customer> getCustomers();
   Customer getCustomerById(Long id);
}

