import java.util.*;


public class ProductManagerImpl implements ProductManager {
    ArrayList<Product> L;
    HashMap<String, User> HM;
    QueueImpl<Order> Q;

    public ProductManagerImpl(){
        L=new ArrayList<>();
        HM=new HashMap<>();
        Q=new QueueImpl<>(20);
    }
    @Override
    public List<Product> productsByPrice() {
        Comparator<Product> priceComparator = Comparator.comparingDouble(Product::getPrice);
        L.sort(priceComparator);
        return L;
    }

    @Override
    public List<Product> productsBySales() {
        Comparator<Product> salesComparator = Comparator.comparingDouble(Product::getSales);
        L.sort(salesComparator.reversed()); //Queremos que nos devuelva la lista de ordenada de mayor a menor.
        return L;
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
    public void addUser(String id, String name, String surname){
        User u = new User(id,name,surname);
        HM.put(id, u);
    }


    @Override
    public Order processOrder() {
        /*Order o = new Order();
        try{o = Q.pop();}
        catch(EmptyQueueException emptyQueueException){
            emptyQueueException.printStackTrace();
        }
        HashMap<String, Integer> h = o.getPedido();
        for(String s: h.keySet()){
            for(Product p : L){
                if(p.getID().equals(s)){
                    int sales = h.get(s) + p.getSales();
                    p.setSales(sales);
                }
            }
        }
        HM.get(o.getID()).addComanda(o);
        return o;
        */
        return Q.pop();

    }
    @Override
    public List<Order> ordersByUser(String userId){
        return HM.get(userId).getOrderList();
    }

}