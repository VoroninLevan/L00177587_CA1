package shapes;

import bounding.BoundingBox;
import java.awt.*;

/**
 * <h1>Circle</h1>
 * <p>Represents rectangular shape. Inherits and implements behavior of Shape.<br>
 * Stores characteristics and describes behavior of the circular shape.<br>
 * Used to draw/fill circular shape on canvas</p>
 *
 * @author Levan.Voronin
 * @version 1.0.0
 * @see Shape
 */
public class Circle extends Shape{

    /**Stores radius and diameter of the circle*/
    private final int radius, diameter;

    /**Stores x and y coordinates of top left corner of the shape*/
    private int x, y;

    /**
     * Constructor for initializing the Circle object with given values
     *
     * @param color used to render the shape
     * @param xCenter x coordinate used for identifying center of shape
     * @param yCenter y coordinate used for identifying center of shape
     * @param radius value represents the radius of the circle
     */
    public Circle(Color color, int xCenter, int yCenter, int radius){
        super(color, xCenter, yCenter);
        this.radius = radius;
        diameter = radius * 2;
        calculateTopLeftCoordinates();
        setBoundingBox(new BoundingBox(x, y, diameter));
    }

    /**
     * Implementation of the abstract method
     * Contains behavioral logic of rendering the shape based on filled value
     * Decides whether to fill or draw the shape
     * @param g used for rendering of the shape
     */
    @Override
    public void renderShape(Graphics g) {
        g.setColor(getColor());
        if(isFilled()){
            fillShape(g);
        } else {
            drawShape(g);
        }
    }

    /**
     * Implementation of the abstract method
     * Draws circular(oval) shape based on provided values
     *
     * @param g used for drawing the shape
     */
    @Override
    public void drawShape(Graphics g) {
        g.drawOval(x, y, diameter, diameter);
    }

    /**
     * Implementation of the abstract method
     * Fills circular(oval) shape based on provided values
     *
     * @param g used to fill the shape
     */
    @Override
    public void fillShape(Graphics g) {
        g.fillOval(x, y, diameter, diameter);
    }

    /**
     * Implementation of the abstract method
     * Renders the name of the class in the center of the shape
     *
     * @param g used to draw string (name of the class)
     */
    @Override
    public void displayName(Graphics g) {
        g.drawString(this.getClass().getSimpleName(), getxCenter(), getyCenter());
    }

    /**
     * Implementation of the abstract method
     * Calculates the top left corner x,y coordinates of the shape based on the center points
     */
    @Override
    public void calculateTopLeftCoordinates() {
        x = getxCenter() - radius;
        y = getyCenter() - radius;
    }

    /**
     * Implementation of the abstract method
     */
    @Override
    public void performSpecialAction() {
        // Implementation is not required
    }
}
