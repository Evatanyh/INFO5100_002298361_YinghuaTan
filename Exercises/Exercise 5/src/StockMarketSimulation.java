public class StockMarketSimulation {
    public static void main(String[] args) {
        MarketConfiguration config = MarketConfiguration.getInstance();
        config.setMarketHours("08:00 - 16:00"); // Adjust market hours

        StockExchange exchange = new StockExchange();
        exchange.registerClient(new WebClientFactory().createClient());
        exchange.registerClient(new MobileAppFactory().createClient());
        exchange.registerClient(new DesktopAppFactory().createClient());

        exchange.updateStockPrice("AAPL", 150.00);
        exchange.updateStockPrice("GOOGL", 2750.00);
        exchange.updateStockPrice("MSFT", 300.00);
    }
}
