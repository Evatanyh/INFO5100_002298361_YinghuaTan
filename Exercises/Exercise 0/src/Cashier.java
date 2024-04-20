import java.util.UUID;
class Cashier {
    public UUID id;
    public String name;

    public Cashier(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        System.out.println("Cashier " + name + " created with id: " + id);
    }

    private double cashInDrawer;

    public void processPayment() {
        System.out.println(name + " is processing payment...");
    }

    public void provideReceipt() {
        System.out.println(name + " is providing the receipt...");
    }

    public void manageTransactions() {
        System.out.println(name + " is managing transactions...");
    }
}
