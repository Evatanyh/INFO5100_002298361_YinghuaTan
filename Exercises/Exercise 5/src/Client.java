import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
interface Client {
    void update(Stock stock);
}

class WebClient implements Client {
    @Override
    public void update(Stock stock) {
        System.out.println("Web Client: " + stock);
    }
}

class MobileApp implements Client {
    @Override
    public void update(Stock stock) {
        System.out.println("Mobile App: " + stock);
    }
}

class DesktopApp implements Client {
    @Override
    public void update(Stock stock) {
        System.out.println("Desktop App: " + stock);
    }
}

class StockExchange {
    private List<Client> clients = new ArrayList<>();
    private Map<String, Stock> stocks = new HashMap<>();

    public void registerClient(Client client) {
        clients.add(client);
    }

    public void updateStockPrice(String symbol, double price) {
        Stock stock = stocks.getOrDefault(symbol, new Stock(symbol, price));
        stock.setPrice(price);
        stocks.put(symbol, stock);
        notifyClients(stock);
    }

    private void notifyClients(Stock stock) {
        for (Client client : clients) {
            client.update(stock);
        }
    }
}

class Stock {
    private String symbol;
    private double price;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Stock [symbol=" + symbol + ", price=" + price + "]";
    }
}
