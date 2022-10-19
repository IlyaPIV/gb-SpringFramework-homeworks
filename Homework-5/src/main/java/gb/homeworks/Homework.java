package gb.homeworks;

import gb.homeworks.customers.Customer;
import gb.homeworks.customers.CustomerDAO;
import gb.homeworks.customers.CustomerDaoImpl;
import gb.homeworks.products.Product;
import gb.homeworks.products.ProductDAO;
import gb.homeworks.products.ProductDaoImpl;

import java.util.List;

public class Homework {

    private final ProductDAO productDAO = new ProductDaoImpl();
    private final CustomerDAO customerDAO = new CustomerDaoImpl();



    public void checkTasks(){

        //homeworkFifth();
        homeworkSix();

    }


    public void homeworkFifth(){
        createProduct();
        findProduct();
        findAllProducts();
        updateProduct();
        deleteProduct();
    }

    public void homeworkSix(){
        findAllCustomers();
        findAllProducts();
    }

    public void createProduct(){
        System.out.println("======== testing CREATE ========");
        Product createdProduct = new Product();
        createdProduct.setTitle("Created Prod");
        createdProduct.setCost(55.17f);
        System.out.println("Created product: " + createdProduct);
        Product savedProduct = productDAO.saveOrUpdate(createdProduct);
        System.out.println("Saved product: " + savedProduct);
    }

    public void findProduct(){
        System.out.println("======== testing FIND BY ID ========");
        Long id = 2L;
        Product product = productDAO.findById(id);
        System.out.println("item with id = 2: " + product);
    }

    public void findAllProducts(){
        System.out.println("======== testing FIND ALL ========");
        List<Product> productList = productDAO.findAll();
        System.out.println("size of table: " + productList.size());
        productList.forEach(System.out::println);
    }

    public void updateProduct(){
        System.out.println("======== testing UPDATE ========");
        Long id = 2L;
        Product product = productDAO.findById(id);
        System.out.println("item (id = 2) before: " + product);
        product.setTitle("Changed Prod");
        product.setCost(13.05f);
        Product updatedProduct = productDAO.saveOrUpdate(product);
        System.out.println("item (id = 2) after: " + updatedProduct);
    }

    public void deleteProduct(){
        System.out.println("======== testing DELETE ========");
        Long id = 2L;
        System.out.println("deleting item with id = 2...");
        productDAO.deleteById(id);
        Product product = productDAO.findById(id);
        System.out.println("result searching item with id = 2: " + product);
    }

    public void findAllCustomers(){
        System.out.println("======== testing FIND ALL CUSTOMERS ========");
        List<Customer> customerList = customerDAO.findAll();
        System.out.println("size of table: " + customerList.size());
        customerList.forEach(System.out::println);
    }

}
