import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *  Program Java Co. Lab Project: Espresso.java <br>
 *  Utilizing the Coffee.java interface, this base class is responsible for creating an espresso drink type
 *  </br>
 *  CS160L-1001 SUMMER2023
 *  6/28/2023
 *  @author Genesis Anne Villar
 *  </pre>
 */

public class Espresso implements Coffee {

    @Override
    public double getCost() {
        return 1.75;              /* An espresso coffee drink type cost 1.75 */
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredients = new ArrayList<>();
        ingredients.add("Espresso");
        return ingredients;
    }

    @Override
    public String printCoffee() {
        return "An espresso";
    }
}

