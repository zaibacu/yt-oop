public class Drink extends Item{
    public Drink(String name, int code, double price) {
        super(name, code, price);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 0.1;
    }
}
