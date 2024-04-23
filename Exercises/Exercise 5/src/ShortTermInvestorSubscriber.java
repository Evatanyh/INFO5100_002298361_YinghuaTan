public class ShortTermInvestorSubscriber implements Subscriber {
    public void notify(String stockSymbol, double price) {
        System.out.println("Short-term investor alert! The price of " + stockSymbol + " is now " + price);
        // Short-term strategy could be triggered here
    }
}