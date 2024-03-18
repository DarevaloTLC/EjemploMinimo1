import java.util.*;


public abstract class ProductManagerImpl implements ProductManager {
    ArrayList<Product> L;
    HashMap<String, User> HM;
    QueueImpl<Order> Q;

    @Override
    public ArrayList<Product> productsByPrice(ArrayList<Product> l) {

        l.sort(new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p1.getPrice(),p2.getPrice());
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

    @Override
    public void addOrder(Order order) {
        try{Q.push(order);}
        catch(FullQueueException fullQueueException){
            fullQueueException.printStackTrace();
        }
    }

    @Override
    public Order processOrder() {
        Order firstOrder = new Order();
        try{
            firstOrder = Q.pop();

        }
        catch(EmptyQueueException emptyQueueException){
            emptyQueueException.printStackTrace();
        }
        HashMap<String, Integer> h = firstOrder.getPedido();
        for(String s: h.keySet()){
            for(Product p: L){
                if(p.getID() == s){
                    double sales = h.get(h) + p.getSales();


                }
            }
        }
        L.get(firstOrder.getID()).addComanda(firstOrder);

    }
}