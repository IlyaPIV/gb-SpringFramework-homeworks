package gb.homeworks.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Basket {

    private static int number = 0;
    private final List<Product> shoppingList;
    private int id;

    public Basket() {
        shoppingList = new ArrayList<>();
        number++;
    }

    @PostConstruct
    private void setBasketId(){
       this.id = number;
    }

    public void addProduct(Product product){
        shoppingList.add(product);
    }

    public void printList(){
        System.out.println("Basket #" + id + ": "+ shoppingList.toString());
    }
}
