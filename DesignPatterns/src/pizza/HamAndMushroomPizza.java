package pizza;

public class HamAndMushroomPizza extends Pizza{
    @Override
    protected void setSpecifics() {
        price = 10;
        diameter = 10;
        ingredients.add("ham");
        ingredients.add("mushrooms");
        ingredients.add("cheese");
    }

    @Override
    public String toString() {
        return "Ham & Shroom " + super.toString();
    }
}
