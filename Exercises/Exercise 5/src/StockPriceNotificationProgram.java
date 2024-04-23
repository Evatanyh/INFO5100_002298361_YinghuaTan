import java.util.Random;

// Other class definitions remain the same...

public class StockPriceNotificationProgram {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int SYMBOL_LENGTH = 3; // Typical length of a stock symbol

    public static String generateRandomSymbol() {
        StringBuilder symbol = new StringBuilder(SYMBOL_LENGTH);
        Random rnd = new Random();

        for (int i = 0; i < SYMBOL_LENGTH; i++) {
            int index = rnd.nextInt(ALPHABET.length());
            symbol.append(ALPHABET.charAt(index));
        }

        return symbol.toString();
    }

    public static void main(String[] args) {
        PriceAlertService alertService = new PriceAlertService();

        SubscriberFactory shortTermFactory = new ShortTermInvestorFactory();
        Subscriber shortTermInvestor = shortTermFactory.createSubscriber();

        SubscriberFactory longTermFactory = new LongTermInvestorFactory();
        Subscriber longTermInvestor = longTermFactory.createSubscriber();

        String stockSymbol = generateRandomSymbol();
        double thresholdPrice = 50.0;

        System.out.println("Monitoring stock: " + stockSymbol);

        alertService.addSubscriber(stockSymbol, shortTermInvestor);
        alertService.addSubscriber(stockSymbol, longTermInvestor);

        // Simulate a scenario where the stock price fluctuates and triggers alerts
        alertService.checkPrice(stockSymbol, thresholdPrice);

        // Remove subscriber if no longer interested
        alertService.removeSubscriber(stockSymbol, longTermInvestor);
    }
}
