package bounding;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * <h1>BoundingBox</h1>
 * <p>By default - invisible box, which is used to register mouse click events in the area where the box is located<br>
 * Can be drawn on canvas for visual representation. Employs Point class to store bottom left and top right corners<br>
 * in form of x,y coordinate, to register mouse click events in its area</p>
 *
 * @author Levan.Voronin
 * @version 1.0.0
 * @see Point
 */
public class BoundingBox {

    /**Stores bottom left coordinates*/
    private Point bottomLeft;

    /**Stores top right coordinates*/
    private Point topRight;

    /**Stores x and y coordinates of top left corner of the box*/
    private int x, y;

    /**Stores width and height of the box*/
    private int width, height;

    /**
     * Constructor to initialize object out of top-left x,y coordinates and diameter.<br>
     * Used for circle shape
     *
     * @param x x coordinate of top-left corner of the box
     * @param y y coordinate of top-left corner of the box
     * @param diameter whole number(int), diameter of a circle
     */
    public BoundingBox(int x, int y, int diameter){
        calculatePointsBasedOnDiameter(x, y, diameter);
        this.x = x;
        this.y = y;
        width = diameter;
        height = diameter;
    }

    /**
     * Constructor to initialize object out of top-left x,y coordinates, width and height.<br>
     *
     * @param x x coordinate of top-left corner of the box
     * @param y y coordinate of top-left corner of the box
     * @param width width value of the object as whole number(int)
     * @param height height value of the object as whole number(int)
     */
    public BoundingBox(int x, int y, int width, int height){
        calculatePoints(x, y, width, height);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Constructor to initialize object out of bottom-left and top-right x,y coordinates.<br>
     *
     * @param bottomLeft Point object storing x,y coordinates
     * @param topRight Point object storing x,y coordinates
     */
    public BoundingBox(Point bottomLeft, Point topRight){
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
        calculateBoundingBoxValues();
    }

    /**
     * Calculates bottom-left and top-right coordinates with given top-left x,y coordinates and diameter.<br>
     * Used for circle shape
     *
     * @param x x coordinate of top-left corner of the box
     * @param y y coordinate of top-left corner of the box
     * @param diameter whole number(int), diameter of a circle
     */
    private void calculatePointsBasedOnDiameter(int x, int y, int diameter){
        bottomLeft = new Point(x, y + diameter);
        topRight = new Point(x + diameter, y);
    }

    /**
     * Calculates bottom-left and top-right coordinates with given top-left x,y coordinates, width and height.<br>
     *
     * @param x x coordinate of top-left corner of the box
     * @param y y coordinate of top-left corner of the box
     * @param width width value of the object as whole number(int)
     * @param height height value of the object as whole number(int)
     */
    private void calculatePoints(int x, int y, int width, int height){
        bottomLeft = new Point(x, y + height);
        topRight = new Point(x + width, y);
    }

    /**
     * Calculates top-left corner coordinates, width and height of the box out of the bottom-left and top-right<br>
     * coordinates
     */
    private void calculateBoundingBoxValues(){
        x = bottomLeft.getX();
        y = topRight.getY();
        width = topRight.getX() - bottomLeft.getX();
        height = bottomLeft.getY() - topRight.getY();
    }

    /**
     * Checks whether the given mouse click event happened within the area of the bounding box
     *
     * @param event given mouse click event
     * @return state based on click within or out of the box
     */
    public boolean isWithinBounds(MouseEvent event){
        int mouseX = event.getX();
        int mouseY = event.getY();
        return (mouseX >= bottomLeft.getX() && mouseX <= topRight.getX()) &&
                (mouseY >= topRight.getY() && mouseY <= bottomLeft.getY());
    }

    /**
     * Draws bounding box as dashed box on canvas for illustrative purpose
     *
     * @param g used for rendering of the box
     */
    public void drawBoundingBox(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        float[] dash1 = { 2f, 0f, 2f };
        Stroke defaultStroke = g2d.getStroke();
        BasicStroke bs1 = new BasicStroke(
                1,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND,
                1.0f, dash1,
                2f);
        g2d.setStroke(bs1);
        g2d.drawRect(x, y, width, height);
        g2d.setStroke(defaultStroke);
    }
}
