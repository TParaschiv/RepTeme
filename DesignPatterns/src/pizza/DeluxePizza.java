package pizza;

public class DeluxePizza extends Pizza {
    @Override
    protected void setSpecifics() {
        price = 50;
        diameter = 10;
        ingredients.add("pineapple");
        ingredients.add("gorgonzola");
        ingredients.add("anchovies");
    }

    @Override
    public String toString() {
        return "Deluxe " + super.toString();
    }
}
