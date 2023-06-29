import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *  Program Java Co. Lab Project: CoffeeOrder.java <br>
 *  Java class which handles the creation of the receipt printed out of a given coffee order total in Main.java.
 *  </br>
 *  CS160L-1001 SUMMER2023
 *  6/28/2023
 *  @author Genesis Anne Villar
 *  </pre>
 */
public class CoffeeOrder {
    private List<Coffee> coffees;
    private LocalDateTime orderDate;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");

    /**
     * Constructs a CoffeeOrder object with the current order date and an empty list of coffees.
     *          This constructor builds a new order and initializes relevant variables.
     */
    public CoffeeOrder() {

        coffees = new ArrayList<Coffee>();
        orderDate = LocalDateTime.now();
    }

    /**
     * Constructs a CoffeeOrder object with a specified order date and an empty list of coffees.
     *
     * @param orderDate the order date and time
     */
    public CoffeeOrder(LocalDateTime orderDate){
        coffees = new ArrayList<Coffee>();
        this.orderDate = orderDate;
    }

    /**
     * Adds a coffee object to the order.
     *
     * @param c the coffee to add
     */
    public void addCoffee(Coffee c) {

        coffees.add(c);
    }

    /**
     * Returns the list of coffees in the order.
     *
     * @return coffee objects in coffees list
     */
    public List<Coffee> getCoffees() {

        return coffees;
    }

    /**
     * Returns the order date and time in computer settings using the class LocalDateTime.
     *
     * @return the order date and time
     */
    public LocalDateTime getOrderDate() {

        return orderDate;
    }

    /**
     * Calculates and returns the total cost of the order by adding each
     * coffee object drink type and its decorators in the coffees list.
     *
     * @return the total cost of the order
     */
    public double getTotal() {
        double total = 0;
        for (Coffee coffee : coffees) {
            total += coffee.getCost();
        }
        return total;
    }

    /**
     * Creates and returns a string representation of the order receipt.
     *          The receipt includes the title, timestamp, list of items with their costs, and the total cost of the order.
     *
     * @return using toString() representation, prints order receipt of coffee order
     */
    public String printOrder() {
        StringBuilder coffeeOrderPrint = new StringBuilder();
        coffeeOrderPrint.append("ORDER RECEIPT\n");
        coffeeOrderPrint.append("Timestamp: ").append(orderDate.format(formatter)).append("\n");  /* Timestamp of receipt */

        for (int i = 0; i < coffees.size(); i++) {  /* every coffee object in the coffees list is formatted accordingly */
            Coffee coffee = coffees.get(i);
             coffeeOrderPrint.append("Item ").append(i + 1).append(": ").append(coffee.printCoffee()).append(" - ").append(String.format("%.2f", coffee.getCost())).append("\n");
        }
        coffeeOrderPrint.append("TOTAL = ").append(String.format("%.2f", getTotal())).append("\n");
        return coffeeOrderPrint.toString();
    }
}
