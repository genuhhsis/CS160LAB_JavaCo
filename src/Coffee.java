import java.util.List;

/**
 * <pre>
 *  Program Java Co. Lab Project: Coffee.java <br>
 *  Interface that only contains abstract methods which define common set of behavior; used by every individual coffee object.
 *  </br>
 *  CS160L-1001 SUMMER2023
 *  6/28/2023
 *  @author Genesis Anne Villar
 *  </pre>
 */
public interface Coffee {
    /**
     * Abstract method that returns the cost of the coffee drink, including any added decorators.
     *
     * @return the cost of the coffee drink
     */
    public double getCost();

    /**
     * Abstract method that creates a list of ingredients,
     * adding them to the base coffee ingredient before returning.
     *
     * @return the list of ingredients for the coffee drink
     */
    public List<String> getIngredients();

    /**
     * Abstract method that acts like a toString() method that builds a string representation of
     * the coffee drink and all of its ingredients.
     *
     * @return a string representation of the coffee drink
     */
    public String printCoffee();
}
