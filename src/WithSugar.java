import java.util.List;

/**
 * <pre>
 *  Program Java Co. Menu Lab Project: WithSugar.java <br>
 *  Decorator subclass inherited from superclass CoffeeDecorator; handles a drink type that includes sugar.
 *  </br>
 *  CS160L-1001 SUMMER2023
 *  6/28/2023
 *  @author Genesis Anne Villar
 *  </pre>
 */
public class WithSugar extends CoffeeDecorator {
    /**
     * Constructs a WithSugar decorator with the specified coffee object.
     *
     * @param c the coffee object to be wrapped
     */
    public WithSugar(Coffee c) {
        super(c);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.15;          /* Sugar costs an additional 0.15 */
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredients = super.getIngredients();       /* inherits CoffeeDecorator so need super */
        ingredients.add("Sugar");
        return ingredients;
    }

    @Override
    public String printCoffee() {
        return super.printCoffee() + " with sugar";
    }
}
