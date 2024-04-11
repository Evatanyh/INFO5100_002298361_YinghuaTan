import java.util.UUID;
class Ingredient {
    public UUID id;
    public String name;

    public Ingredient(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        System.out.println("Ingredient " + name + " created with id: " + id);
    }

    private String supplier;
    private double quantity;

    public void checkStock() {
        System.out.println("Checking stock for " + name + "...");
    }

    public void orderMore() {
        System.out.println("Ordering more " + name + "...");
    }

    public void restock() {
        System.out.println("Restocking " + name + "...");
    }
}