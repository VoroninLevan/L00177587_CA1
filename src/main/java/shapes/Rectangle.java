package shapes;

import bounding.BoundingBox;
import bounding.Point;
import interfaces.MoveAble;
import java.awt.*;

/**
 * <h1>Rectangle</h1>
 * <p>Represents rectangular shape. Inherits and implements behavior of Shape. Provides implementation for<br>
 * MoveAble interface.<br>
 * Stores characteristics and describes behavior of the rectangular shape.<br>
 * Used to draw/fill rectangular shape on canvas</p>
 *
 * @author Levan.Voronin
 * @version 1.0.0
 * @see Shape
 * @see MoveAble
 */
public class Rectangle extends Shape implements MoveAble {

    /**Stores width of rect*/
    private final int width;

    /**Stores height of rect*/
    private final int height;

    /**Stores x and y coordinates of top left corner of the shape*/
    private int x, y;

    /**
     * Constructor for initializing the Rectangle object with given values
     *
     * @param color used to render the shape
     * @param xCenter x coordinate used for identifying center of shape
     * @param yCenter y coordinate used for identifying center of shape
     * @param width width value of the object as whole number(int)
     * @param height height value of the object as whole number(int)
     */
    public Rectangle(Color color, int xCenter, int yCenter, int width, int height){
        super(color, xCenter, yCenter);
        this.width = width;
        this.height = height;
        calculateTopLeftCoordinates();
        setBoundingBox(new BoundingBox(x, y, width, height));
    }

    /**
     * Getter method to retrieve width of the object
     *
     * @return whole number(int) width value
     */
    public int getWidth() {
        return width;
    }

    /**
     * Getter method to retrieve height of the object
     *
     * @return whole number(int) height value
     */
    public int getHeight() {
        return height;
    }

    /**
     * Getter method to retrieve x,y coordinates of the top left corner of the object
     *
     * @return Point object containing x,y coordinates
     */
    public Point getTopLeftCoordinates(){
        return new Point(x, y);
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
     * Draws rectangular shape based on provided values
     *
     * @param g used for drawing the shape
     */
    @Override
    public void drawShape(Graphics g) {
        g.drawRect(x, y, width, height);
    }

    /**
     * Implementation of the abstract method
     * Fills rectangular shape based on provided values
     *
     * @param g used to fill the shape
     */
    @Override
    public void fillShape(Graphics g) {
        g.fillRect(x, y, width, height);
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
     * Implementation of the interface method
     * Moves the shape by 10 units(int) horizontally to the right
     * Special action method
     */
    @Override
    public void moveTenXUnits() {
        updatexCenter(getxCenter() + 10);
        calculateTopLeftCoordinates();
        setBoundingBox(new BoundingBox(x, y, width, height));
    }

    /**
     * Implementation of the abstract method
     * Calculates the top left corner x,y coordinates of the shape based on the center points
     */
    @Override
    public void calculateTopLeftCoordinates(){
        x = getxCenter() - width/2;
        y = getyCenter() - height/2;
    }

    /**
     * Implementation of the abstract method
     * Calls special action method
     */
    @Override
    public void performSpecialAction() {
        moveTenXUnits();
    }
}
