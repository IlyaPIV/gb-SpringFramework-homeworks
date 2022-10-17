package gb.homeworks.customers;

import gb.homeworks.SessionFactoryUtils;
import org.hibernate.Session;

import java.util.List;

public class CustomerDaoImpl implements CustomerDAO{

    @Override
    public Customer saveOrUpdate(Customer customer) {
        try(Session session = SessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(customer);
            session.getTransaction().commit();
        }
        return customer;
    }

    @Override
    public Customer findById(Long id) {
        try(Session session = SessionFactoryUtils.getSession()){
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            session.getTransaction().commit();
            return customer;
        }
    }

    @Override
    public List<Customer> findAll() {
        try(Session session = SessionFactoryUtils.getSession()){
            session.beginTransaction();
            List<Customer> customerList = session.createQuery("SELECT c FROM Customer  c", Customer.class).getResultList();
            session.getTransaction().commit();
            return customerList;
        }
    }

    @Override
    public void deleteById(Long id) {
        try(Session session = SessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            session.delete(customer);
            session.getTransaction().commit();
        }
    }
}
