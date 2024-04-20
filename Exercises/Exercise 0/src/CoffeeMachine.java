import java.util.UUID;
class CoffeeMachine {
    public UUID id;
    public String name;

    public CoffeeMachine(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        System.out.println("Coffee Machine " + name + " created with id: " + id);
    }

    private String color = "black";
    private String brand = "Nespresso";
    private int capacity = 500;

    public void brew() {
        System.out.println("Brewing coffee using " + name + "...");
    }

    public void clean() {
        System.out.println("Cleaning " + name + " coffee machine...");
    }
}