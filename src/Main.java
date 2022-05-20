import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Item> products = new ArrayList<>();

        products.add(new Drink("Coca Cola", 4, 0.9));
        products.add(new Drink("Coca Cola", 4, 0.9));
        products.add(new Drink("Coca Cola", 4, 0.9));
        products.add(new Snack("Lays", 5, 0.75));
        products.add(new Snack("Studentų Maistas", 6, 4.75));

        Map<Integer, List<Item>> productsStack = new HashMap<>();

        for(Item p : products) {
            List<Item> items = new ArrayList<>();
            if(productsStack.containsKey(p.getCode())){
                items = productsStack.get(p.getCode());
            }
            else {
                productsStack.put(p.getCode(), items);
            }

            items.add(p);

            System.out.println(p);
        }

        Scanner scanner = new Scanner(System.in);
        Item selectItem;
        while(true) {
            System.out.print("Please enter product code: ");
            int userSelection = scanner.nextInt();
            if(productsStack.containsKey(userSelection)) {
                if(productsStack.get(userSelection).size() > 0){
                    selectItem = productsStack.get(userSelection).get(0);
                    productsStack.get(userSelection).remove(0);
                    break;
                }
                else {
                    System.err.printf("No more items with product code: %d.\n", userSelection);
                }
            }
            else {
                System.err.println("Incorrect product code.");
            }
        }

        System.out.printf("User selection: %s. Final price: %.2f", selectItem, selectItem.getPrice());


    }
}
