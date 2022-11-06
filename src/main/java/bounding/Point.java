package bounding;

/**
 * <h1>Point</h1>
 * <p>Used to store x and y coordinate information.<br>
 * Initialization through constructor. Only getter methods available</p>
 *
 * @author Levan.Voronin
 * @version 1.0.0
 */
public class Point {

    /**Stores x and y coordinates*/
    private final int x, y;

    /**
     * Constructor used for object initialization and populating data
     *
     * @param x x coordinate in form of whole number(int)
     * @param y y coordinate in form of whole number(int)
     */
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Getter method to retrieve x coordinate
     *
     * @return x coordinate(int)
     */
    public int getX() {
        return x;
    }

    /**
     * Getter method to retrieve y coordinate
     *
     * @return y coordinate(int)
     */
    public int getY() {
        return y;
    }
}
