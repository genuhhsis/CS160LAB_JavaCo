import java.util.List;

/**
 * <pre>
 *  Program Java Co. Lab Project: CoffeeDecorator.java <br>
 *  Superclass which serves as a base for decorator subclasses ;provides concrete implementations.
 *  </br>
 *  CS160L-1001 SUMMER2023
 *  6/28/2023
 *  @author Genesis Anne Villar
 *  </pre>
 */
public abstract class CoffeeDecorator implements Coffee {
    private Coffee coffee;

    /**
     * Constructs a coffee decorator that accepts specified wrapped coffee object
     *
     * @param c the coffee object to be wrapped
     */
    public CoffeeDecorator(Coffee c) {

        coffee = c;
    }

    /**
     * Returns the cost of the coffee drink with the price of any decorators added.
     *          This method delegates the call to the wrapped coffee object.
     *
     * @return the cost of the coffee drink
     */
    public double getCost() {
        return coffee.getCost();
    }

    /**
     * Returns the list of ingredients for the coffee drink, including any decorators added.
     *          This method delegates the call to the wrapped coffee object.
     *
     * @return the list of ingredients for the coffee drink
     */
    public List<String> getIngredients() {
        return coffee.getIngredients();
    }

    /**
     * Returns a string representation of the coffee drink, including any decorators added.
     *          This method delegates the call to the wrapped coffee object.
     *
     * @return a string representation of the coffee drink
     */
    public String printCoffee() {
        return coffee.printCoffee();
    }

}
