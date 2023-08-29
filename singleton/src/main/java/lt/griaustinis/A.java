package lt.griaustinis;

public class A {
    private B b;
    public A(B b) {
        this.b = b;
    }

    public void action(C c) {
        Config config = Config.getInstance();
        System.out.printf("Name of C: %s. API KEY: %s\n", c.getName(), config.getApiKey());
    }
}
