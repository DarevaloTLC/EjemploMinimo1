import java.util.ArrayList;
import java.util.HashMap;


public class Order {
    private String UserID;
    private HashMap<String, Integer> pedido;
    public Order(String id, HashMap<String, Integer> c)
    {
        this.UserID = id;
        this.pedido = c;
    }
    public Order(){

    }
    public HashMap<String, Integer> getPedido(){
        return this.pedido;
    }

    public void setPedido(HashMap<String, Integer> h) {
        this.pedido=h;
    }

    public String getID(){
        return this.UserID;
    }
    public void setID(String i){
        this.UserID = i;
    }
    public void addLP(String id, Integer num){
        pedido.put(id, num);
    }



}
