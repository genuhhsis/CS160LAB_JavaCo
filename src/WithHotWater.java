import java.util.List;

/**
 * <pre>
 *  Program Java Co. Menu Lab Project: WithHotWater.java <br>
 *  Decorator subclass inherited from superclass CoffeeDecorator; handles a drink type that includes hot water.
 *  </br>
 *  CS160L-1001 SUMMER2023
 *  6/28/2023
 *  @author Genesis Anne Villar
 *  </pre>
 */
public class WithHotWater extends CoffeeDecorator {
    /**
     * Constructs a WithHotWater decorator with the specified coffee object.
     *
     * @param c the coffee object to be wrapped
     */
    public WithHotWater(Coffee c) {
        super(c);
    }


    @Override
    public double getCost() {
        return super.getCost();     /* cost remains the same as the wrapped coffee object since hot water does not add any additional cost */
    }


    @Override
    public List<String> getIngredients() {
        List<String> ingredients = super.getIngredients();      /* inherits CoffeeDecorator so need super */
        ingredients.add("Hot Water");
        return ingredients;
    }

    @Override
    public String printCoffee() {
        return super.printCoffee() + " with hot water";
    }
}
