public abstract class Producto {

    private String name;
    private double price;
    
    public Producto (String name, double price){
        setName(name);
        setPrice(price);
    }

    public String getName(){
        return name;
    }

    public void setName(String newValue) {
        if(newValue == null || newValue.trim().isEmpty()){
            throw new IllegalArgumentException("The name can't be empthy");
        }
         this.name = newValue; 
    }



    public double getPrice(){
        return price;
    }

    public void setPrice(double newValue) {
        if(newValue <= 0){
            throw new IllegalArgumentException("The price must be greater than 0");
        }
        this.price = newValue; 
    }



    public abstract String getDescription(); 
}














