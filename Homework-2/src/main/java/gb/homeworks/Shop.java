package gb.homeworks;

import gb.homeworks.beans.Basket;
import gb.homeworks.beans.Product;
import gb.homeworks.beans.ProductsRepository;
import org.springframework.context.ApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Shop {
    private static final int REPO_SIZE = 8;
    private final ApplicationContext context;
    private final ProductsRepository repository;
    private final List<Basket> baskets;
    private Basket currentBasket = null;

    public Shop(ApplicationContext context) {
        this.context = context;
        this.repository = context.getBean(ProductsRepository.class);
        this.baskets = new ArrayList<>();
    }

    public void work(){
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String input = "";
            initProductList();
            printMenu();
            while (!(input = br.readLine()).equals("exit")) {
                switch (input) {
                    case "1" -> getAndPrintList();
                    case "2" -> initProductList();
                    case "3" -> addNewBasket();
                    case "4" -> findProdById(br);
                    case "5" -> finishThisBasket();
                    default -> System.out.println("Unknown command. Try again.");
                }
                printMenu();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
     * удаляет текущую корзину; если есть другие, то из списка первая становится текущей
     */
    private void finishThisBasket() {
        baskets.remove(currentBasket);
        this.currentBasket = null;
        if (baskets.size()>0) {
            currentBasket = baskets.get(0);
        }
    }


    /*
     * вывод в консоль список команд
     */
    private void printMenu(){
        System.out.println("========== MENU ==========");
        System.out.println("> 1\t-\tPrint products list");
        System.out.println("> 2\t-\tRefresh product list");
        System.out.println("> 3\t-\tAdd new shipping basket");
        if (currentBasket != null) {
            System.out.println("> 4\t-\tAdd product to basket");
            System.out.println("> 5\t-\tPay for current basket");
        }
        System.out.println("> exit\t-\tStop shopping");
        if (currentBasket != null) {
            System.out.println("---------------------------");
            System.out.println("!!! CURRENT Basket: ");
            currentBasket.printList();
            printOtherBaskets();
        }
        System.out.println();

    }

    /*
     * очищает и генерирует новый список продуктов
     */
    private void initProductList() {
        repository.clearProductList();
        repository.initProductList(REPO_SIZE);
    }

    /*
     * получает текущий список продуктов и выводит на экран
     */
    private void getAndPrintList(){
        List<Product> productList = repository.getProductList();
        productList.sort(new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getId()-p2.getId();
            }
        });

        System.out.println("=== Actual Product List ===");
        for (Product prod:
                productList) {
            System.out.println(prod);
        }
        System.out.println("===========================");
    }

    /*
     * создаёт новую продуктовую корзину
     */
    private void addNewBasket(){
        Basket newBasket = context.getBean(Basket.class);
        this.currentBasket = newBasket;
        this.baskets.add(newBasket);

    }

    /*
     * выводит содержимое остальных (кроме текущей) корзин
     */
    private void printOtherBaskets(){
        if (baskets.size()>1) {
            System.out.println("OTHER baskets:");
            for (Basket b:
                 baskets) {
                if (b != currentBasket){
                    b.printList();
                }
            }
        }
    }

    /*
     * ищет продукт по ID и добавляет его в текущую корзину
     */
    private void findProdById(BufferedReader br){
        System.out.print("Input prod id >>>");
        int id = 0;
        try {
            id = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException("Uncorrected input data");
        }

        try {
            Product prod = repository.getProductById(id);
            currentBasket.addProduct(prod);
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
