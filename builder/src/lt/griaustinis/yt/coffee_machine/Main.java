package lt.griaustinis.yt.coffee_machine;

public class Main {
    public static void main(String[] args){
        Drink myCoffee = CoffeeMachine.espresso(0);
        System.out.println(myCoffee);
    }
}
