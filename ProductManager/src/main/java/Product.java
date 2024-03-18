public class Product {
    String ID;
    String name;
    Double price;
    public String GetID(){
        return this.ID;
    }
    public String GetName(){
        return this.name;
    }
    public double GetPrice(){
        return this.price;
    }
    public Product(String i, String n, Double p){
        this.ID = i;
        this.name = n;
        this.price = p;
    }

}
