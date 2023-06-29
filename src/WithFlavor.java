import java.util.List;

/**
 * <pre>
 *  Program Java Co. Menu Lab Project: WithFlavor.java <br>
 *  Decorator subclass inherited from superclass CoffeeDecorator; handles a drink type that includes a Syrup flavor.
 *              All syrup flavors are implemented as enums.
 *  </br>
 *  CS160L-1001 SUMMER2023
 *  6/28/2023
 *  @author Genesis Anne Villar
 *  </pre>
 */

public class WithFlavor extends CoffeeDecorator {

    enum Syrup {
        CARAMEL,
        MOCHA,
        VANILLA
    }

    private Syrup flavor;

    /**
     * Constructs a WithFlavor decorator with the specified coffee object and syrup flavor.
     *
     * @param c the coffee object to be wrapped
     * @param s the syrup flavor to add to the coffee drink
     */
    public WithFlavor(Coffee c, Syrup s) {
        super(c);
        flavor = s;
    }


    @Override
    public double getCost() {
        return super.getCost() + 0.35;       /* A flavor syrup costs an additional 0.35 */
    }

    /**
     * Returns the list of ingredients for the coffee drink with the added syrup flavor.
     *          The ingredients are obtained from the wrapped coffee object, and the syrup flavor is added to the list of ingredients based on string representation of enum name.
     *
     * @return the list of ingredients for the coffee drink with the added syrup flavor
     */
    @Override
    public List<String> getIngredients() {
        List<String> ingredients = super.getIngredients();      //inherits CoffeeDecorator so need super
        ingredients.add(String.valueOf(flavor));
        return ingredients;
    }

    /**
     * Returns a string representation of the coffee drink with the added syrup flavor.
     *          The syrup flavor name is based on string representation of enum name of said syrup.
     *
     * @return a string representation of the coffee drink with the added syrup flavor
     */
    @Override
    public String printCoffee() {
        return super.printCoffee() + " with " + flavor;
    }
}
