package pizza;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {

    protected double price;
    protected double diameter;
    protected List<String> ingredients;

    public Pizza() {
        ingredients = new ArrayList<>();
        this.setSpecifics();
    }

    public double getPrice() {
        return price;
    }

    public double getDiameter() {
        return diameter;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    protected abstract void setSpecifics();

    @Override
    public String toString() {
        return "diameter:" + diameter + "\tprice: " + price;
    }
}
