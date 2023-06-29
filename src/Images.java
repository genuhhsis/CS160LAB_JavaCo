import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Objects;
/**
 * <pre>
 *  Program Java Co. Lab Project: Images.java <br>
 *  Java class which handles a gui that shows a visual for the menu ordering interface.
 *              This class was largely inspired from the following YouTube video:  @see <a href= "https://www.youtube.com/watch?v=FdQX8sUNO-s&ab_channel=WinstonLievsay"> Reference video by: Winston Lievsay  </a>
 *              This reference was also good for looking up additional information on GUI @see <a href= "https://www.geeksforgeeks.org/jlabel-java-swing/"> GeeksforGeeks: Java Swing </a>
 *              This reference was also used for making my Gui @see <a href= "https://www.geeksforgeeks.org/creating-frames-using-swings-java/"> GeeksforGeeks: Creating Frames using Swings in Java</a>
 *  </br>
 *  CS160L-1001 SUMMER2023
 *  6/28/2023
 *  @author Genesis Anne Villar, Winston Lievsay
 *  </pre>
 */


public class Images extends JFrame {
    private ImageIcon blackCoffee;
    private JLabel blackCoffeeLabel;
    private ImageIcon espresso;
    private  JLabel espressoLabel;
    private ImageIcon hotWater;
    private  JLabel hotWaterLabel;
    private ImageIcon milk;
    private  JLabel milkLabel;
    private ImageIcon sugar;
    private  JLabel sugarLabel;
    private ImageIcon whippedCream;
    private  JLabel whippedCreamLabel;
    private ImageIcon flavor;
    private  JLabel flavorLabel;
    private ImageIcon flavorVANILLA;
    private  JLabel flavorVANILLALabel;
    private ImageIcon flavorMOCHA;
    private  JLabel flavorMOCHALabel;
    private ImageIcon flavorCARAMEL;
    private  JLabel flavorCARAMELLabel;

    /**
     * Constructs an instance of the Images class.
     * Initializes the GUI layout and adds the coffee images with their corresponding labels.
     */
    Images() {
        setLayout(new FlowLayout());
        getContentPane().removeAll();

        getContentPane().removeAll();
        blackCoffee = new ImageIcon(getClass().getResource("blackcoffee.jpg"));
        Image blackCoffeeImage = blackCoffee.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        blackCoffee = new ImageIcon(blackCoffeeImage);
        blackCoffeeLabel = new JLabel(blackCoffee);
        blackCoffeeLabel.setText("Java Co.'s Famous Black Coffee! It costs $1.00");
        add(blackCoffeeLabel);

        espresso = new ImageIcon(getClass().getResource("espresso.jpg"));
        Image espressoImage = espresso.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        espresso = new ImageIcon(espressoImage);
        espressoLabel = new JLabel(espresso);
        espressoLabel.setText("Java Co.'s Famous Espresso Coffee! It costs $1.75");
        add(espressoLabel);

        revalidate();
        repaint();
    }

    /**
     * Updates the images and labels of the drink types in the GUI.
     * Removes the previous images and labels, and adds the new ones.
     * This is mainly for updating the images when a NEW coffee is created in the coffee order.
     */
    public void updateImagesDrinkTypes() {
        getContentPane().removeAll();

        blackCoffee = new ImageIcon(getClass().getResource("blackcoffee.jpg"));
        Image blackCoffeeImage = blackCoffee.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        blackCoffee = new ImageIcon(blackCoffeeImage);
        blackCoffeeLabel = new JLabel(blackCoffee);
        blackCoffeeLabel.setText("Java Co.'s Famous Black Coffee! It costs $1.00");
        add(blackCoffeeLabel);

        espresso = new ImageIcon(getClass().getResource("espresso.jpg"));
        Image espressoImage = espresso.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        espresso = new ImageIcon(espressoImage);
        espressoLabel = new JLabel(espresso);
        espressoLabel.setText("Java Co.'s Famous Espresso Coffee! It costs $1.75");
        add(espressoLabel);

        revalidate();
        repaint();
    }

    /**
     * Updates the images and labels of the decorator options in the GUI.
     * Removes the previous images and labels, and adds the new ones.
     * Since the decorator menu option has more options, a new JPanel is created
     * Each instance of an image is separated by the image labels
     */
    public void updateImagesDecorator() {
        // Update the image icons

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        hotWater = new ImageIcon(getClass().getResource("hotwater.jpg"));
        Image hotWaterImage = hotWater.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        hotWater = new ImageIcon(hotWaterImage);
        hotWaterLabel = new JLabel(hotWater);
        hotWaterLabel.setText("Add hot water? There is no additional charge.");
        panel.add(hotWaterLabel);

        milk = new ImageIcon(getClass().getResource("milk.jpg"));
        Image milkImage = milk.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        milk = new ImageIcon(milkImage);
        milkLabel = new JLabel(milk);
        milkLabel.setText("Add milk? It costs an additional $0.55");
        panel.add(milkLabel);

        sugar = new ImageIcon(getClass().getResource("sugar.jpg"));
        Image sugarImage = sugar.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        sugar = new ImageIcon(sugarImage);
        sugarLabel = new JLabel(sugar);
        sugarLabel.setText("Add sugar? It costs an additional $0.15");
        panel.add(sugarLabel);

        whippedCream = new ImageIcon(getClass().getResource("whippedcream.jpg"));
        Image whippedCreamImage = whippedCream.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        whippedCream = new ImageIcon(whippedCreamImage);
        whippedCreamLabel = new JLabel(whippedCream);
        whippedCreamLabel.setText("Add whipped cream? It costs an additional $0.25");
        panel.add(whippedCreamLabel);

        flavor = new ImageIcon(getClass().getResource("flavor.jpg"));
        Image flavorImage = flavor.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        flavor = new ImageIcon(flavorImage);
        flavorLabel = new JLabel(flavor);
        flavorLabel.setText("Add a flavored syrup? It costs an additional $0.35");
        panel.add(flavorLabel);

        add(panel);

        // Refresh the GUI
        revalidate();
        repaint();
    }

    /**
     * Updates the images and labels of the flavor options in the GUI.
     * Removes the previous images and labels, and adds the new ones.
     */
    public void updateImagesFlavor() {
        // Update the image icons
        getContentPane().removeAll();

        flavorVANILLA = new ImageIcon(getClass().getResource("vanilla.jpg"));
        Image flavorVANILLAImage = flavorVANILLA.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        flavorVANILLA = new ImageIcon(flavorVANILLAImage);
        flavorVANILLALabel = new JLabel(flavorVANILLA);
        flavorVANILLALabel.setText("Vanilla syrup fancying you?");
        add(flavorVANILLALabel);

        flavorMOCHA = new ImageIcon(getClass().getResource("mocha.jpg"));
        Image flavorMOCHAImage = flavorMOCHA.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        flavorMOCHA = new ImageIcon(flavorMOCHAImage);
        flavorMOCHALabel = new JLabel(flavorMOCHA);
        flavorMOCHALabel.setText("How about mocha for the chocolate lovers?");
        add(flavorMOCHALabel);

        flavorCARAMEL = new ImageIcon(getClass().getResource("caramel.jpg"));
        Image flavorCARAMELImage = flavorCARAMEL.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        flavorCARAMEL = new ImageIcon(flavorCARAMELImage);
        flavorCARAMELLabel = new JLabel(flavorCARAMEL);
        flavorCARAMELLabel.setText("Caramel is always a good choice!");
        add(flavorCARAMELLabel);

        revalidate();
        repaint();
    }

    public void closeGUI() {
        getContentPane().removeAll();
        revalidate();
        repaint();
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    public static void main(String args[]){
        Images gui = new Images();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.pack();
        gui.setVisible(true);
    }
}
