abstract class ClientFactory {
    public abstract Client createClient();
}

class WebClientFactory extends ClientFactory {
    @Override
    public Client createClient() {
        return new WebClient();
    }
}

class MobileAppFactory extends ClientFactory {
    @Override
    public Client createClient() {
        return new MobileApp();
    }
}

class DesktopAppFactory extends ClientFactory {
    @Override
    public Client createClient() {
        return new DesktopApp();
    }
}
