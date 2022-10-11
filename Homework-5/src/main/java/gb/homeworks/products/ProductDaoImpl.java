package gb.homeworks.products;

import gb.homeworks.SessionFactoryUtils;
import org.hibernate.Session;

import java.util.List;

public class ProductDaoImpl implements ProductDAO{
    @Override
    public Product saveOrUpdate(Product product) {
        try(Session session = SessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
        return product;
    }

    @Override
    public Product findById(Long id) {
        try(Session session = SessionFactoryUtils.getSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<Product> findAll() {
        try(Session session = SessionFactoryUtils.getSession()){
            session.beginTransaction();
            List<Product> productList = session.createQuery("SELECT p FROM Product  p", Product.class).getResultList();
            session.getTransaction().commit();
            return productList;
        }
    }

    @Override
    public void deleteById(Long id) {
        try(Session session = SessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }
}
