import java.util.UUID;
class Menu {
    public UUID id;
    public String name;

    public Menu(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        System.out.println("Menu " + name + " created with id: " + id);
    }

    private String[] items;
    private double[] prices;

    public void display() {
        System.out.println("Displaying " + name + " menu...");
    }

    public void update() {
        System.out.println("Updating " + name + " menu...");
    }
}