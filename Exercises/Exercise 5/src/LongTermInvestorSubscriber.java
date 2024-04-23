public class LongTermInvestorSubscriber implements Subscriber {
    public void notify(String stockSymbol, double price) {
        System.out.println("Long-term investor alert! The price of " + stockSymbol + " reached " + price);
        // Long-term strategy could be triggered here
    }
}