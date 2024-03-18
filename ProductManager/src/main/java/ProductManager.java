import java.util.ArrayList;
import java.util.List;
public interface ProductManager {
    public List<Product> productsByPrice();
    public List<Product> productsBySales();
    public void addOrder(Order order);
    public Order processOrder();
    public List<Order> ordersByUser(String userId);

    public void addUser(String s, String name, String surname);

    ArrayList<Product> productsByPrice(ArrayList<Product> l);

    ArrayList<Product> productsBySales(ArrayList<Product> l);

    public void addProduct(String productId, String name, double price);
}