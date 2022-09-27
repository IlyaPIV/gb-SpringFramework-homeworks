package gb.homeworks.beans;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ProductsGenerator {
    private static final Random rnd = new Random();

    public List<Product> generateList(int size){
        List<Product> list = new ArrayList<>();
        int lastId = 1;
        int scale = 100;
        for (int i = 0; i < size; i++) {
            int id = rnd.nextInt(5) + lastId;
            lastId = id + 1;
            String name = "Product #" + id;

            float price = Math.round(rnd.nextFloat(1000f) * scale) * 1f / scale;

            list.add(new Product(id, name, price));
        }

        return list;
    }
}
