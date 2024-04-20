import java.util.UUID;
class Supplier {
    public UUID id;
    public String name;

    public Supplier(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        System.out.println("Supplier " + name + " created with id: " + id);
    }

    private String[] productsSupplied;
    private double[] prices;

    public void deliverProducts() {
        System.out.println(name + " is delivering products...");
    }

    public void updateInventory() {
        System.out.println(name + " is updating inventory...");
    }

    public void manageOrders() {
        System.out.println(name + " is managing orders...");
    }
}