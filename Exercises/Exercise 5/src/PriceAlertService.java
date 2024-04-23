import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
public class PriceAlertService {
    private Map<String, List<Subscriber>> subscribersMap = new HashMap<>();

    public void addSubscriber(String stockSymbol, Subscriber subscriber) {
        if (!subscribersMap.containsKey(stockSymbol)) {
            subscribersMap.put(stockSymbol, new ArrayList<>());
        }
        subscribersMap.get(stockSymbol).add(subscriber);
    }

    public void removeSubscriber(String stockSymbol, Subscriber subscriber) {
        if (subscribersMap.containsKey(stockSymbol)) {
            subscribersMap.get(stockSymbol).remove(subscriber);
        }
    }

    public void notifySubscribers(String stockSymbol, double price) {
        if (subscribersMap.containsKey(stockSymbol)) {
            for (Subscriber subscriber : subscribersMap.get(stockSymbol)) {
                subscriber.notify(stockSymbol, price);
            }
        }
    }

    public void checkPrice(String stockSymbol, double threshold) {
        double currentPrice = MarketDataFetcher.getInstance().getPrice(stockSymbol);
        if (currentPrice >= threshold) {
            notifySubscribers(stockSymbol, currentPrice);
        }
    }
}