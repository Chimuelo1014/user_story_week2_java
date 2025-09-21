public class Alimento extends Producto{
    public Alimento (String name, double price){
        super(name, price);
    }
   
    @Override
    public String getDescription(){
        return "Alimento perecedero o de consumo";
    }
}




