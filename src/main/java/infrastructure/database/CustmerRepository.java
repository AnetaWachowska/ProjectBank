package infrastructure.database;

import infrastructure.entity.Customer;

public interface CustmerRepository { //byt który po zaimplementowaniu go w klasie narzuca zaimplementowanie ciała metod
    public Customer saveCustomer(Customer customer);
    public void delateCustomer(Long id);
    //dodać metody abstrakcyjne
    //updateCustomer
    //getCustomer(id);
    //getCustomers();

}
