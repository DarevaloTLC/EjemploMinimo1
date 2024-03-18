import java.util.*;

public abstract class ProductManagerImpl implements ProductManager {
    ArrayList<Product> L;
    HashMap<String, User> HM;
    LinkedList<Order> Q; //Preguntar por que hay que poner esta cola.

    @Override
    public ArrayList<Product> productsByPrice(ArrayList<Product> l) {

        l.sort(new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p1.GetPrice(),p2.GetPrice());
            }
        });
        return l;

    }

    @Override
    public ArrayList<Product> productsBySales(ArrayList<Product> l) {
        return l;
    }

    @Override
    public void addProduct(String productId, String name, double price) {
        Product p = new Product(productId, name, price);
        L.add(p);
    }
}