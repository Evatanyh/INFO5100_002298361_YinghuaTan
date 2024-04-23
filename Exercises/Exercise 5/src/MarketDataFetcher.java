public class MarketDataFetcher {
    private static MarketDataFetcher instance;

    private MarketDataFetcher() {}

    public static synchronized MarketDataFetcher getInstance() {
        if (instance == null) {
            instance = new MarketDataFetcher();
        }
        return instance;
    }

    public double getPrice(String stockSymbol) {
        // Placeholder for actual price fetching logic
        return Math.random() * 100;
    }
}
