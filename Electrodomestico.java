public class Electrodomestico extends Producto {
    public Electrodomestico(String name, double price){
        super(name,price);
    }
   
    @Override
    public String getDescription(){
        return "Electrodomestico con garantía";
    }
}


