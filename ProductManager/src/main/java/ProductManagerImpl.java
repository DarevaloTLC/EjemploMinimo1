import java.util.*;


public class ProductManagerImpl implements ProductManager {
    private static List<Product> L;
    private static HashMap<String, User> HM;
    private static QueueImpl<Order> Q;

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
        try{
            Q.push(order);
            User user = HM.get(order.getID());
            if(user != null){
                user.addComanda(order);
            }
            else{
                throw new IllegalArgumentException("Usuario no encontrado para la orden con ID: " + order.getID());
            }
        }
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
        Order processedOrder = new Order();
        try{
            processedOrder = Q.pop();
            HashMap<String, Integer> productsInOrder = processedOrder.getPedido();

            for(Map.Entry<String, Integer> entry : productsInOrder.entrySet()){
                String productId = entry.getKey();
                Integer quantity = entry.getValue();
                updateProductSales(productId, quantity);
            }
        }
        catch (EmptyQueueException emptyQueueException){
            emptyQueueException.printStackTrace();
        }
        return processedOrder;



    }
    @Override
    public List<Order> ordersByUser(String userId){
        User user = HM.get(userId);
        if(user != null){
            return user.getOrderList();
        }
        else {
            return null;
        }
    }

    public void updateProductSales(String productId, int quantity){
        Product product = new Product();
        for(Product p : L){
            if(p.getID().equals(productId)){
                product = p;
                break;
            }
        }
        product.incrementSales(quantity);
    }

}