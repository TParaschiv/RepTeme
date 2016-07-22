package pizza;

public class ProsciutoPizza extends Pizza {
    @Override
    protected void setSpecifics() {
        price = 5;
        diameter = 10;
        ingredients.add("prosciuto");
        ingredients.add("cheese");
    }

    @Override
    public String toString() {
        return "Prosciuto " + super.toString();
    }
}
