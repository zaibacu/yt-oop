package lt.griaustinis.yt.coffee_machine;

public class Sugar implements Ingredient{
    private int volume;

    public Sugar(int volume) {
        this.volume = volume;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return String.format("Sugar: %d cubes", this.getVolume());
    }
}
