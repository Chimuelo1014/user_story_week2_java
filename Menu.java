import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.util.Comparator;
public class Menu {
    ArrayList<Producto> inventory = new ArrayList<>();
    HashMap<String, Integer> stock = new HashMap<>();
    double total = 0.0;
    ArrayList<Producto> purchases = new ArrayList<>();
    
    public void mainMenu(){


    String option;
    do {
    option = JOptionPane.showInputDialog(null,"Entry a option\n1 Add product\n2 List Inventary\n3 Buy product\n4 Stadistics\n5 Search Product\n6 Exit","Main menu",-1);
    switch(option) {
        case "1":
            addProduct();
            break;
        case "2":
            listInventary();
            break;
        case "3":
            buyProduct();
            break;

        case "4":
            stadistics();
            break;
        case "5":
            searchProduct();
            break;
        case "6":
            exit();
            break;

        default :
            JOptionPane.showMessageDialog(null, "Invalid Input","Error",1);
            break;

    }
    }
    while (!option.equals("6"));


    }

    public void addProduct(){
        int type = validateInt("Enter the type of product\n1 Food\n2 Appliance", "Type");
        String name = validateString("Enter the name of product", "Name");

        boolean existe = false;
        for (Producto p : inventory) {
            if (p.getName().equalsIgnoreCase(name)) { 
                existe = true;
                break;
            }
        }

        if (existe) {
            JOptionPane.showMessageDialog(null, "That product already exists in inventory, please try again.","invalid", -1);
            addProduct();
            return;
        }
        double price = validateDouble("Enter the price of product", "Price");
        int amount = validateInt("Enter the stock of product", "Stock");
        if(type == 1){
            Alimento a = new Alimento(name,price);
            inventory.add(a);
            stock.put(name,amount);
        }else if (type == 2){
            Electrodomestico e = new Electrodomestico(name, price);
            inventory.add(e);
            stock.put(name,amount);
        }

    }


    public void listInventary(){
        if (inventory.isEmpty()){
            JOptionPane.showMessageDialog(null, "The inventary is empty","inventary",-1 );
            return;
        }
        String message = "Inventary\n\n";
        for (Producto p : inventory) {  
            message += ("| Nombre : "+p.getName()+"| Precio : "+p.getPrice()+"| Stock : "+stock.get(p.getName())+"| Descripcion  : "+p.getDescription()+"|\n");
        }
        JOptionPane.showMessageDialog(null, message, "Inventary", -1);
    }

    public void buyProduct() {
    String name = validateString("Enter the name of product", "Name");
    int amount = validateInt("Enter the amount of "+name, "Amount");

    boolean found = false;
    for (Producto p : inventory) {
        if (p.getName().equalsIgnoreCase(name)) {
            found = true;
            if(stock.get(p.getName()) >= amount){
                stock.put(p.getName(), stock.get(p.getName()) - amount);
                total += p.getPrice() * amount;
                purchases.add(p);
            } else {
                JOptionPane.showMessageDialog(null,"Quantity greater than stock","Invalid",1);
            }
            break;
        }
    }
    if(!found){
        JOptionPane.showMessageDialog(null,"The product does not exist","Invalid", 1);
    }
}




    public void stadistics(){
        if(inventory.isEmpty()){
            JOptionPane.showMessageDialog(null,"The inventary is empty");
            return;
        }
        inventory.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        JOptionPane.showMessageDialog(null, "The cheapest :\n"+"|Name : "+inventory.get(0).getName()+" | Price : "+inventory.get(0).getPrice()+" | Amount : "+stock.get(inventory.get(0).getName())+" | Description :  "+inventory.get(0).getDescription()+"\nthe most expensive: \n"+"|Name : "+inventory.get(inventory.size()-1).getName()+" | Price : "+inventory.get(inventory.size()-1).getPrice()+" | Amount : "+stock.get(inventory.get(inventory.size()-1).getName())+" | Description : "+inventory.get(inventory.size()-1).getDescription(), "Stadistics", -1);
    }


    public void searchProduct(){
    String search = validateString("Enter the name of product to search","Search");
    String message = "";
    for(Producto p : inventory){
        if(p.getName().toLowerCase().contains(search.toLowerCase())){
            message += ("| Name : "+p.getName()+"| Price : "+p.getPrice()+"| Stock : "+stock.get(p.getName())+"| Description  : "+p.getDescription()+"|\n"); 
        }
    }
    if(message.isEmpty()){
        JOptionPane.showMessageDialog(null, "No results for this name");
    } else {
        JOptionPane.showMessageDialog(null,message,"Results",-1);
    }
}


    public void exit(){
        String message = "";
        for(Producto p : purchases){
            message += ("| Name : "+p.getName()+"| Price : "+p.getPrice()+"| Description  : "+p.getDescription()+"|\n");
        }
        JOptionPane.showMessageDialog(null,message+"\n Total : "+total,"Purchases", -1);
    }

    public String validateString(String input, String tittle){
    String validate = JOptionPane.showInputDialog(null,input,tittle, -1);
    
    if (validate == null) { 
        JOptionPane.showMessageDialog(null, "Input cancelled, please try again.", "Info", JOptionPane.INFORMATION_MESSAGE);
        return validateString(input, tittle);
    }

    if (validate.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "The value cannot be empty", "Invalid", JOptionPane.ERROR_MESSAGE);
        return validateString(input, tittle);
    }

    return validate;
}


    public double validateDouble(String input, String tittle){
    String val = JOptionPane.showInputDialog(null,input,tittle,-1);

    if (val == null) { 
        JOptionPane.showMessageDialog(null,"Input cancelled, please try again.","Info", JOptionPane.INFORMATION_MESSAGE);
        return validateDouble(input,tittle);
    }

    if (!val.matches("\\d+(\\.\\d+)?")) { 
        JOptionPane.showMessageDialog(null,"Please enter a valid decimal number.","Invalid", JOptionPane.ERROR_MESSAGE);
        return validateDouble(input,tittle);
    }

    double numero = Double.parseDouble(val);
    if (numero < 0) {
        JOptionPane.showMessageDialog(null,"The number cannot be negative.","Invalid", JOptionPane.ERROR_MESSAGE);
        return validateDouble(input,tittle);
    }

    return numero;
}



    public int validateInt(String input, String tittle){
    String val = JOptionPane.showInputDialog(null,input,tittle,-1);

    if (val == null) { 
        JOptionPane.showMessageDialog(null,"Input cancelled, please try again.","Info", JOptionPane.INFORMATION_MESSAGE);
        return validateInt(input,tittle);
    }

    if (!val.matches("\\d+")) { 
        JOptionPane.showMessageDialog(null,"Please enter a valid integer.","Invalid", JOptionPane.ERROR_MESSAGE);
        return validateInt(input,tittle);
    }

    int numero = Integer.parseInt(val);
    if (numero < 0) {
        JOptionPane.showMessageDialog(null,"The number cannot be negative.","Invalid", JOptionPane.ERROR_MESSAGE);
        return validateInt(input,tittle);
    }

    return numero;
}

}