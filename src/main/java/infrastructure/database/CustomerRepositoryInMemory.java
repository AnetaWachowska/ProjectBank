package infrastructure.database;

import infrastructure.entity.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepositoryInMemory implements CustmerRepository {

    private final List<Customer> customers = new ArrayList<Customer>();
    private static Long id = 1L;

    @Override //to nam wskazuje ze jest to metoda  która została nadpisana
    public Customer saveCustomer(Customer customer) {
        Customer dbCustomer = new Customer(id++, customer);
        customers.add(dbCustomer);
        return dbCustomer;
    }


    @Override
    public void delateCustomer(Long id) {
        Optional<Customer> optionalCustomer = customers.stream() //ropoczynamy wyszukiwanie customera
                .filter(customer -> customer.getId().equals(id))
                .findFirst(); //metoda wybiera by jeden element po wyfiltrowaniu, zwaraca nam jeden obiekt
        Customer customer = optionalCustomer.orElseThrow(() -> new RuntimeException("No such customer")); // sprawdzam czy nie jest nullem jezli nie to zapisuje do zmiennej cutomer jezeli tak to rzucamy wyjatek
        customers.remove(customer);// gdy program nie rzucił nam bledem no such... to tutaj przechodzimy do linkiji gdzie wywołujemy metodę remove

    }
}
