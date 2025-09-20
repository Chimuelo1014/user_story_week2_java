import javax.swing.JOptionPane;
public class Menu {
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
    while (option != "6");




// Estadísticas:
// Encontrar producto más caro y más barato
// Buscar producto:
// Permite coincidencias parciales por nombre


// Salir:
// Muestra ticket final con total de compras
    }

    public void addProduct(){
        String type = JOptionPane.showInputDialog(null,"Type", "Enter the type of product\n1 Food\n2 Appliance", 1);
        String name = JOptionPane.showInputDialog(null,"Name", "Enter the name of product",-1);
        double price = JOptionPane.showInputDialog(null,"Price", "Enter the price of product",-1);
        int stock = JOptionPane.showInputDialog(null,"Stock", "Enter the stock of product",-1);
        //validar por name si ya esta
        // if (){
            
        // }
    }


    public void listInventary(){
        // Recorre ArrayList y HashMap
        // Muestra nombre, precio, stock y descripción (getDescripcion())
    }

    // Comprar producto:
    // Solicita nombre y cantidad
    // Valida stock y actualiza
    // Genera ticket parcial
    public void buyProduct() {
        String name = JOptionPane.showInputDialog(null,"Name", "Enter the name of product",-1);
        String amount = JOptionPane.showInputDialog(null,"Amount", "Enter the amount of "+name,-1);

    }

    // Estadísticas:
// Encontrar producto más caro y más barato


    public void stadistics();{


    }

    // Buscar producto:
// Permite coincidencias parciales por nombre

    public void searchProduct(){

    }

    public void Exit(){
        
    }
}