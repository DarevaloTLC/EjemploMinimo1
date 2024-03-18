import java.util.ArrayList;

public class User {
    private String ID;
    private String name;
    private String lastname;
    private ArrayList<Order> orderList;
    public User(String i, String n, String ln){
        this.ID = i;
        this.name = n;
        this.lastname = ln;
    }
    public User(){

    }
    public String GetID(){
        return this.ID;
    }
    public String GetName(){
        return this.name;
    }
    public String GetLastName(){
        return this.lastname;
    }
    public void SetID(String id){
        this.ID=id;
    }
    public void SetName(String n){
        this.name=n;
    }
    public void SetLastName(String ls){
        this.lastname=ls;
    }
    public void addComanda(Order o){
        orderList.add(o);
    }


}
