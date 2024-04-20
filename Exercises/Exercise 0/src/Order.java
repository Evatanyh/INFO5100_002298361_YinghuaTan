import java.util.UUID;
class Order {
    public UUID id;
    public String name;

    public Order(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        System.out.println("Order " + name + " created with id: " + id);
    }

    private String[] items;
    private double totalPrice;

    public void addItem() {
        System.out.println("Adding item to " + name + " order...");
    }

    public void removeItem() {
        System.out.println("Removing item from " + name + " order...");
    }

    public void calculateTotalPrice() {
        System.out.println("Calculating total price for " + name + " order...");
    }
}
