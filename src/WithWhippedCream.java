import java.util.List;

/**
 * <pre>
 *  Program Java Co. Menu Lab Project: WithWhippedCream.java <br>
 *  Decorator subclass inherited from superclass CoffeeDecorator; handles a drink type that includes whipped cream.
 *  </br>
 *  CS160L-1001 SUMMER2023
 *  6/28/2023
 *  @author Genesis Anne Villar
 *  </pre>
 */
public class WithWhippedCream extends CoffeeDecorator {
    /**
     * Constructs a WithWhippedCream decorator with the specified coffee object.
     *
     * @param c the coffee object to be wrapped
     */
    public WithWhippedCream(Coffee c) {
        super(c);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.25;          /* Whipped cream costs an additional 0.25 */
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredients = super.getIngredients();       /* inherits CoffeeDecorator so need super */
        ingredients.add("Whipped Cream");
        return ingredients;
    }

    @Override
    public String printCoffee() {
        return super.printCoffee() + " with whipped cream";
    }

}
