import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *  Program Java Co. Lab Project: BlackCoffee.java <br>
 *  Utilizing the Coffee.java interface, this base class is responsible for creating a black coffee drink type.
 *  </br>
 *  CS160L-1001 SUMMER2023
 *  6/28/2023
 *  @author Genesis Anne Villar
 *  </pre>
 */
public class BlackCoffee implements Coffee {

    @Override
    public double getCost() {
        return 1.0;              /* A black coffee drink type cost 1.00 */
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredients = new ArrayList<>();
        ingredients.add("Black Coffee");
        return ingredients;
    }

    @Override
    public String printCoffee() {
        return "A black coffee";
    }
}
