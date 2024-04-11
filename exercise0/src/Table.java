import java.util.UUID;
class Table {
    public UUID id;
    public String name;

    public Table(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        System.out.println("Table " + name + " created with id: " + id);
    }

    private int capacity;
    private boolean isOccupied = false;

    public void occupy() {
        isOccupied = true;
        System.out.println(name + " table is now occupied.");
    }

    public void vacate() {
        isOccupied = false;
        System.out.println(name + " table is now vacant.");
    }
}