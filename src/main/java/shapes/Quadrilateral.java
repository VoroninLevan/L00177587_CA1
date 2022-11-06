package shapes;

import java.awt.*;

import bounding.BoundingBox;
import bounding.Point;
import interfaces.Rotatable;

/**
 * <h1>Quadrilateral</h1>
 * <p>Represents quadrilateral shape. Inherits and implements behavior of Shape. Provides implementation for<br>
 * Rotatable interface.<br>
 * Stores characteristics and describes behavior of the quadrilateral shape.<br>
 * Used to draw/fill quadrilateral shape on canvas</p>
 *
 * @author Levan.Voronin
 * @version 1.0.0
 * @see Shape
 * @see Rotatable
 */
public class Quadrilateral extends Shape implements Rotatable {

    /**Stores array of Point objects to identify quadrilateral vertices*/
    private Point[] points;

    /**Stores x coordinates of quadrilateral vertices*/
    private int[] xCoordinates;

    /**Stores x coordinates of quadrilateral vertices*/
    private int[] yCoordinates;

    /**Tracks if color provided*/
    private boolean isColorProvided;

    /**
     * Constructor for initializing the Quadrilateral object with given values
     *
     * @param centerPoint central x,y coordinates of the shape
     * @param points array of Point objects containing vertices x,y coordinates
     */
    public Quadrilateral(Point centerPoint, Point[] points){
        super(centerPoint);
        this.points = points;
        separatePointCoordinates();
        initializeBoundingBox();
    }

    /**
     * Constructor for initializing the Quadrilateral object with given values
     *
     * @param color used to render the shape
     * @param centerPoint central x,y coordinates of the shape
     * @param points array of Point objects containing vertices x,y coordinates
     */
    public Quadrilateral(Color color, Point centerPoint, Point[] points){
        super(color, centerPoint);
        this.points = points;
        separatePointCoordinates();
        initializeBoundingBox();
        isColorProvided = true;
    }

    /**
     * Constructor for initializing the Quadrilateral object with given values
     *
     * @param centerPoint central x,y coordinates of the shape
     * @param p1 Vertex 1 x,y coordinates
     * @param p2 Vertex 2 x,y coordinates
     * @param p3 Vertex 3 x,y coordinates
     * @param p4 Vertex 4 x,y coordinates
     */
    public Quadrilateral(Point centerPoint, Point p1, Point p2, Point p3, Point p4){
        super(centerPoint);
        points = new Point[]{p1, p2, p3, p4};
        separatePointCoordinates();
        initializeBoundingBox();
    }

    /**
     * Constructor for initializing the Quadrilateral object out of Rectangle object
     *
     * @param rectangle Rectangle object
     */
    public Quadrilateral(Rectangle rectangle){
        super(new Point(rectangle.getxCenter(), rectangle.getyCenter()));
        definePointsFromRect(rectangle);
        separatePointCoordinates();
        initializeBoundingBox();
    }

    /**
     * Implementation of the abstract method
     * Contains behavioral logic of rendering the shape based on filled value
     * Decides whether to fill or draw the shape
     * @param g used for rendering of the shape
     */
    @Override
    public void renderShape(Graphics g) {
        if(isColorProvided){
            g.setColor(getColor());
        } else {
            g.setColor(Color.BLACK);
        }

        if(isFilled()){
            fillShape(g);
        } else {
            drawShape(g);
        }
    }

    /**
     * Implementation of the abstract method
     * Draws quadrilateral shape based on provided values
     *
     * @param g used for drawing the shape
     */
    @Override
    public void drawShape(Graphics g) {
        g.drawPolygon(xCoordinates, yCoordinates, points.length);
    }

    /**
     * Implementation of the abstract method
     * Fills quadrilateral shape based on provided values
     *
     * @param g used to fill the shape
     */
    @Override
    public void fillShape(Graphics g) {
        g.fillPolygon(xCoordinates, yCoordinates, points.length);
    }

    /**
     * Implementation of the abstract method
     * Renders the name of the class in the center of the shape
     *
     * @param g used to draw string (name of the class)
     */
    @Override
    public void displayName(Graphics g) {
        g.drawString(this.getClass().getSimpleName(), getCenterPoint().getX(), getCenterPoint().getY());
    }

    /**
     * Implementation of the abstract method
     */
    @Override
    public void calculateTopLeftCoordinates() {
        // Implementation is not required
    }

    /**
     * Implementation of the interface method
     * Rotates the shape by 90 degrees(int)
     * Special action method
     * Translates degrees to radians to calculate cos and sin.
     * Based on center x,y points and current vertices(x,y) positions - calculates prime x,y in order to rotate<br>
     * points against 0,0 point of the vector graph.
     * Updates vertices x,y coordinates in relative arrays (xCoordinates, yCoordinates)
     * Initializes new BoundingBox as part of the process
     */
    @Override
    public void rotateNinetyDegrees() {

        double rad = Math.toRadians(90);
        double cos = Math.cos(rad), sin = Math.sin(rad);
        // Storing center points
        int xCenter = getCenterPoint().getX();
        int yCenter = getCenterPoint().getY();
        int length = xCoordinates.length;

        for(int a = 0; a < length; a++){
            // Calculate primes
            int xP = xCoordinates[a] - xCenter;
            int yP = yCenter - yCoordinates[a];
            // Calculating new points and storing them back in arrays
            double xTemp = xP * cos + yP * sin + xCenter;
            double yTemp = yP * cos - xP * sin + yCenter;
            xCoordinates[a] = (int)xTemp;
            yCoordinates[a] = (int)yTemp;
        }
        initializeBoundingBox();
    }

    /**
     * Implementation of the abstract method
     * Calls special action method
     */
    @Override
    public void performSpecialAction() {
        rotateNinetyDegrees();
    }

    /**
     * Calculates four points (vertices) of the rectangle to initialize new Point object each, containing relative<br>
     * x, y coordinates
     *
     * @param rect Rectangular object
     */
    private void definePointsFromRect(Rectangle rect){
        Point point1 = rect.getTopLeftCoordinates();
        Point point2 = new Point(point1.getX() + rect.getWidth(), point1.getY());
        Point point3 = new Point(point2.getX(), point2.getY() + rect.getHeight());
        Point point4 = new Point(point1.getX(), point3.getY());
        points = new Point[]{point1, point2, point3, point4};
    }

    /**
     * Separates x and y coordinates from points array and stores the values in relative arrays<br>
     * (xCoordinates, yCoordinates)
     */
    private void separatePointCoordinates(){
        xCoordinates = new int[points.length];
        yCoordinates = new int[points.length];
        for(int x = 0; x < points.length; x++){
            xCoordinates[x] = points[x].getX();
            yCoordinates[x] = points[x].getY();
        }
    }

    /**
     * Initializes new BoundingBox object out of separately stored x and y coordinate arrays
     */
    private void initializeBoundingBox(){
        setBoundingBox(new BoundingBox(
                new Point(identifySmallerOfArray(xCoordinates), identifyBiggerOfArray(yCoordinates)),
                new Point(identifyBiggerOfArray(xCoordinates), identifySmallerOfArray(yCoordinates))));
    }

    /**
     * Identifies and returns the bigger value stored in array
     *
     * @param coordinates array of x or y coordinates
     * @return the bigger value(int) stored in array
     */
    private int identifyBiggerOfArray(int[] coordinates){
        int tempPoint = 0;
        for(int i : coordinates){
            tempPoint = Math.max(tempPoint, i);
        }
        return tempPoint;
    }

    /**
     * Identifies and returns the smallest value stored in array
     *
     * @param coordinates array of x or y coordinates
     * @return the smallest value(int) stored in array
     */
    private int identifySmallerOfArray(int[] coordinates){
        int tempPoint = 0;
        boolean isFirst = true;
        for(int i : coordinates){
            if (isFirst){
                tempPoint = i;
                isFirst = false;
                continue;
            }
            tempPoint = Math.min(tempPoint, i);
        }
        return tempPoint;
    }
}
