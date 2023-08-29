package lt.griaustinis.yt.coffee_machine;

public class Milk implements Ingredient{
    private boolean steamed;
    private int volume;

    public Milk(int volume, boolean steamed) {
        this.volume = volume;
        this.steamed = steamed;
    }

    public boolean isSteamed(){
        return steamed;
    }
    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return String.format("Milk: %d (ml)", this.getVolume());
    }
}
