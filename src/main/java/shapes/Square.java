package shapes;

import java.awt.*;

/**
 * <h1>Square</h1>
 * <p>Represents Square shape, inherits characteristics and behavior of the parent class(Rectangle), including<br>
 * object moving </p>
 *
 * @author Levan.Voronin
 * @version 1.0.0
 * @see Rectangle
 * @see Shape
 * @see interfaces.MoveAble
 */
public class Square extends Rectangle{

    /**
     * Constructor for Square object initialization with given values
     *
     * @param color used to render the shape
     * @param xCenter x coordinate used for identifying center of shape
     * @param yCenter y coordinate used for identifying center of shape
     * @param edgeLength length(int) of square length
     */
    public Square(Color color, int xCenter, int yCenter, int edgeLength) {
        super(color, xCenter, yCenter, edgeLength, edgeLength);
    }
}
