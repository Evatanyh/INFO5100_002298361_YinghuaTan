import java.util.UUID;
class Customer {
    public UUID id;
    public String name;

    public Customer(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        System.out.println("Customer " + name + " created with id: " + id);
    }

    private int tableNumber;
    private String[] order;

    public void placeOrder() {
        System.out.println(name + " is placing an order...");
    }

    public void enjoyCoffee() {
        System.out.println(name + " is enjoying the coffee...");
    }

    public void payBill() {
        System.out.println(name + " is paying the bill...");
    }
}
