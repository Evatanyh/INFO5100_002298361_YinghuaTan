import java.util.UUID;
class Barista {
    public UUID id;
    public String name;

    public Barista(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        System.out.println("Barista " + name + " created with id: " + id);
    }

    private String specialization;

    public void makeCoffee() {
        System.out.println(name + " is making coffee...");
    }

    public void takeOrder() {
        System.out.println(name + " is taking an order...");
    }

    public void serveCustomer() {
        System.out.println(name + " is serving a customer...");
    }
}