public class ShortTermInvestorFactory extends SubscriberFactory {
    public Subscriber createSubscriber() {
        return new ShortTermInvestorSubscriber();
    }
}