package pizza;

public class Main {
    public static void main(String[] args) {
        /* -------------- Ex2 --------------  */
        System.out.println(" -------------- Ex2 -------------- ");
        System.out.println(PizzaFactory.getPizza(PizzaType.HAM_AND_MUSHROOMS));
        System.out.println(PizzaFactory.getPizza(PizzaType.DELUXE));
        System.out.println(PizzaFactory.getPizza(PizzaType.PROSCIUTO));
    }
}
