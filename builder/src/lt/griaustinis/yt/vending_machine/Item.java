package lt.griaustinis.yt.vending_machine;

public abstract class Item {
    private String name;
    private int code;
    private double price;

    public Item(String name, int code, double price) {
        this.name = name;
        this.code = code;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("<lt.griaustinis.yt.vending_machine.Item name='%s' code='%d' price=%.2f€>", name, code, price);
    }
}
