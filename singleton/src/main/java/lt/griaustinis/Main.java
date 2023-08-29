package lt.griaustinis;

public class Main {
    public static void main(String[] args) {
        C c = new C("Hello");
        B b = new B();
        A a = new A(b);

        a.action(c);

        Config config = Config.getInstance();
    }
}
