public class LongTermInvestorFactory extends SubscriberFactory {
    public Subscriber createSubscriber() {
        return new LongTermInvestorSubscriber();
    }
}