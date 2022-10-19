package gb.homeworks.customers;

import java.util.List;

public interface CustomerDAO {

    public Customer saveOrUpdate(Customer customer);

    public Customer findById(Long id);

    public List<Customer> findAll();

    public void deleteById(Long id);
}
