import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        // Instantiate at least 3 objects of each class
        CoffeeMachine[] coffeeMachines = new CoffeeMachine[3];
        for (int i = 0; i < 3; i++) {
            coffeeMachines[i] = new CoffeeMachine("Coffee Machine " + (i + 1));
        }

        Barista[] baristas = new Barista[3];
        for (int i = 0; i < 3; i++) {
            baristas[i] = new Barista("Barista " + (i + 1));
        }

        Table[] tables = new Table[3];
        for (int i = 0; i < 3; i++) {
            tables[i] = new Table("Table " + (i + 1));
        }

        Menu[] menus = new Menu[3];
        for (int i = 0; i < 3; i++) {
            menus[i] = new Menu("Menu " + (i + 1));
        }

        Customer[] customers = new Customer[3];
        for (int i = 0; i < 3; i++) {
            customers[i] = new Customer("Customer " + (i + 1));
        }

        Cashier[] cashiers = new Cashier[3];
        for (int i = 0; i < 3; i++) {
            cashiers[i] = new Cashier("Cashier " + (i + 1));
        }

        Supplier[] suppliers = new Supplier[3];
        for (int i = 0; i < 3; i++) {
            suppliers[i] = new Supplier("Supplier " + (i + 1));
        }

        Order[] orders = new Order[3];
        for (int i = 0; i < 3; i++) {
            orders[i] = new Order("Order " + (i + 1));
        }

        Ingredient[] ingredients = new Ingredient[3];
        for (int i = 0; i < 3; i++) {
            ingredients[i] = new Ingredient("Ingredient " + (i + 1));
        }
    }
}