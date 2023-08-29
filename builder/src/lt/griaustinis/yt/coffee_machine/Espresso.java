package lt.griaustinis.yt.coffee_machine;

public class Espresso implements Ingredient{
    private int volume;
    public Espresso(int volume){
        this.volume = volume;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return String.format("Espresso: %d (ml)", this.getVolume());
    }
}
