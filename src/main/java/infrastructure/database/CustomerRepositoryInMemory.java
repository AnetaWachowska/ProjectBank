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
    public void deleteCustomer(Long id) {
        customers.remove(findCustomerById(id));// gdy program nie rzucił nam bledem no such... to tutaj przechodzimy do linkiji gdzie wywołujemy metodę remove
    }

    @Override
    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public Customer getCustomerById(Long id) {
        return findCustomerById(id);
    }

    @Override
    public Customer updateCustomer(Long id, Integer pinNumber, String mail) {
        Customer customerFromDb = findCustomerById(id); //wyciąga "starego customer" i tworzymy kolejny obiekt
        Customer customer = new Customer(customerFromDb.getFirstName(), customerFromDb.getLastName(),
                customerFromDb.getNumberIdCard(), pinNumber, mail);
        customers.remove(customerFromDb);
        Customer customerToSave = new Customer(customerFromDb.getId(), customer);
        customers.add(customerToSave);
        return customerToSave;
    }

    private Customer findCustomerById(Long id) {
        Optional<Customer> optionalCustomer = customers.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst();
        return optionalCustomer.orElseThrow(() -> new RuntimeException("No such customer"));
    }

}
