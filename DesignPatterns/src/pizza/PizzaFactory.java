package pizza;

public class PizzaFactory {

    public static Pizza getPizza(PizzaType type) {
        switch (type) {
            case DELUXE:
                return new DeluxePizza();
            case PROSCIUTO:
                return new ProsciutoPizza();
            case HAM_AND_MUSHROOMS:
                return new HamAndMushroomPizza();
            default:
                return null;
        }
    }
}
