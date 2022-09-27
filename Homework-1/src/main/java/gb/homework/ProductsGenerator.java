package gb.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductsGenerator {

    private static final Random rnd = new Random();

    public static List<Product> generateList(int size){
        List<Product> list = new ArrayList<>();
        int lastId = 0;
        for (int i = 0; i < size; i++) {
            int id = rnd.nextInt(5) + lastId;
            lastId = id + 1;
            String name = "Product #" + id;
            float price = rnd.nextFloat(1000f);

            list.add(new Product(id, name, price));
        }

        return list;
    }

}
