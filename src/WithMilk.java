import java.util.List;

/**
 * <pre>
 *  Program Java Co. Menu Lab Project: WithMilk.java <br>
 *  Decorator subclass inherited from superclass CoffeeDecorator; handles a drink type that includes milk.
 *  </br>
 *  CS160L-1001 SUMMER2023
 *  6/28/2023
 *  @author Genesis Anne Villar
 *  </pre>
 */
public class WithMilk extends CoffeeDecorator {
    /**
     * Constructs a WithMilk decorator with the specified coffee object.
     *
     * @param c the coffee object to be wrapped
     */
    public WithMilk(Coffee c) {
        super(c);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.55;              /* Milk costs an additional 0.55 */
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredients = super.getIngredients();       /* inherits CoffeeDecorator so need super */
        ingredients.add("Milk");
        return ingredients;
    }

    @Override
    public String printCoffee() {
        return super.printCoffee() + " with milk";
    }
}
