package gb.homeworks;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    public static void main(String[] args) {

        Shop shop = new Shop(new AnnotationConfigApplicationContext(MyConfig.class));
        shop.work();

    }

}