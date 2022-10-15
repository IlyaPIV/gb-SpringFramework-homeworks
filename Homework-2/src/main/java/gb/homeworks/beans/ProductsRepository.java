package gb.homeworks.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ProductsRepository {

    @Autowired
    private ProductsGenerator prodGen;

    private final ConcurrentHashMap<Integer, Product> priceList;

    public ProductsRepository() {
        priceList = new ConcurrentHashMap<>();
    }

    public void initProductList(int size) {
        List<Product> productList = prodGen.generateList(size);
        for (Product prod:
             productList) {
            priceList.put(prod.getId(), prod);
        }
    }

    public List<Product> getProductList() {
        return new ArrayList<>(priceList.values());
    }

    public void clearProductList(){
        priceList.clear();
    }


    public Product getProductById(int id) throws RuntimeException{
        Product prod = priceList.get(id);
        if (prod == null) throw new RuntimeException("No such product with ID = " + id + " in list");
        return priceList.get(id);
    }
}
