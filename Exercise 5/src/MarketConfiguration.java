public class MarketConfiguration {
    private static MarketConfiguration instance;
    private String marketHours;

    private MarketConfiguration() {
        marketHours = "09:00 - 17:00"; // Default market hours.
    }

    public static MarketConfiguration getInstance() {
        if (instance == null) {
            instance = new MarketConfiguration();
        }
        return instance;
    }

    public String getMarketHours() {
        return marketHours;
    }

    public void setMarketHours(String hours) {
        this.marketHours = hours;
    }
}
