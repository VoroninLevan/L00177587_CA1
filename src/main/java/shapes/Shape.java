package shapes;

import bounding.BoundingBox;
import bounding.Point;
import java.awt.*;

/**
 * <h1>Shape</h1>
 * <p>An abstract class which defines the behaviour of the objects which inherits of it.<br>
 * Each Shape stores own instance of BoundingBox to register mouse click events on the Shape<br>
 * Being a parent class for other shape classes: Rectangle, Circle, Quadrilateral</p>
 *
 * @author Levan.Voronin
 * @version 1.0.0
 * @see Rectangle
 * @see Circle
 * @see Quadrilateral
 * @see BoundingBox
 */
public abstract class Shape {

    /**Stores the color value for display purpose*/
    private Color color;

    /**Tracks is shape filled with color*/
    private boolean filled;

    /**Stores Center x coordinate of the shape*/
    private int xCenter;

    /**Stores Center x coordinate of the shape*/
    private int yCenter;

    /**Stores BoundingBox object*/
    private BoundingBox boundingBox;

    /**Stores center point for quadrilaterals*/
    private Point centerPoint;

    /**
     * Default constructor
     */
    public Shape(){}

    /**
     * Constructor used for Quadrilateral
     *
     * @param centerPoint center point of the shape
     */
    public Shape(Point centerPoint){
        this.centerPoint = centerPoint;
    }

    /**
     * Constructor used for Quadrilateral
     *
     * @param color used to render the shape
     * @param centerPoint center point of shape
     */
    public Shape(Color color, Point centerPoint){
        this.color = color;
        this.centerPoint = centerPoint;
    }

    /**
     * Constructor used for Rectangle, Square, Circle shapes
     *
     * @param color used to render the shape
     * @param xCenter x coordinate used for identifying center of shape
     * @param yCenter y coordinate used for identifying center of shape
     */
    public Shape(Color color, int xCenter, int yCenter){
        this.color = color;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
    }

    /**
     * Getter method for Color variable
     *
     * @return Color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Renders shape for given Graphics
     *
     * @param g used for rendering of the shape
     */
    public abstract void renderShape(Graphics g);

    /**
     * Draws shape for given Graphics
     *
     * @param g used for drawing the shape
     */
    public abstract void drawShape(Graphics g);

    /**
     * Fills shape for given Graphics
     *
     * @param g used to fill the shape
     */
    public abstract void fillShape(Graphics g);

    /**
     * Displays name of the shape for given Graphics
     *
     * @param g used to draw string (name of the class)
     */
    public abstract void displayName(Graphics g);

    /**
     * Calculates top left x and y coordinates.
     * Used for the shape rendering and used to set up a bounding box
     */
    public abstract void calculateTopLeftCoordinates();

    /**
     * Performs special action (depends on the shape child type)
     */
    public abstract void performSpecialAction();

    /**
     * Checks whether the shape is currently filled with color
     *
     * @return boolean based on filled value
     */
    public boolean isFilled() {
        return filled;
    }

    /**
     * Updates filled variable
     */
    public void updateFilled() {
        filled = !filled;
    }

    /**
     * Getter method to retrieve xCenter var
     *
     * @return int value of xCenter
     */
    public int getxCenter() {
        return xCenter;
    }

    /**
     * Getter method to retrieve yCenter var
     *
     * @return int value of yCenter
     */
    public int getyCenter() {
        return yCenter;
    }

    /**
     * Getter method to retrieve BoundingBox object
     *
     * @return BoundingBox object
     */
    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    /**
     * Used to initialize BoundingBox object
     *
     * @param boundingBox BoundingBox object which would be used for initialization
     */
    public void setBoundingBox(BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }

    /**
     * Getter method to retrieve Point objects which stores center coordinates(x,y) ofthe shape
     *
     * @return Point object
     */
    public Point getCenterPoint() {
        return centerPoint;
    }

    /**
     * Updates xCenter variable
     * Used for moving the shape horizontally
     *
     * @param xCenter amount to move as whole number(int)
     */
    public void updatexCenter(int xCenter) {
        this.xCenter = xCenter;
    }
}
