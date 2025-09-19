import javax.swing.JOptionPane;
public class Menu {
    public void mainMenu(){
    String option;
    do {
    option = JOptionPane.showInputDialog(null,"Entry a option\n1 Add product\n2 List Inventary\n3 Buy product\n4 Stadistics\n5 Search Product\n6 Exit","Main menu",-1);
    switch(option) {
        case "1":

            break;
        case "2":
            break;
        case "3":
            break;

        case "4":
            break;
        case "5":
            break;
        case "6":
            break;

        default :
            JOptionPane.showMessageDialog(null, "Invalid Input","Error",1);
            break;

    }
    }
    while (option != "6");
//         Agregar producto:
// Pide tipo (Alimento/Electrodoméstico)
// Solicita nombre, precio y stock
// Valida que no exista duplicado
// Listar inventario:
// Recorre ArrayList y HashMap
// Muestra nombre, precio, stock y descripción (getDescripcion())
// Comprar producto:
// Solicita nombre y cantidad
// Valida stock y actualiza
// Genera ticket parcial
// Estadísticas:
// Encontrar producto más caro y más barato
// Buscar producto:
// Permite coincidencias parciales por nombre
// Salir:
// Muestra ticket final con total de compras
    }
}