package manager;

import shapes.Shape;

import java.awt.*;
import java.util.ArrayList;

/**
 * <h1>ShapesManager</h1>
 */
public class ShapesManager {

    /**Stores available shapes*/
    ArrayList<Shape> shapes;

    /**Stores data for name display decision*/
    private boolean displayShapeName;

    /**Stores data for bounding box display decision*/
    private boolean displayBoundingBox;

    /**
     * Default constructor
     */
    public ShapesManager(){
        shapes = new ArrayList<>();
    }

    /**
     * Stores new shape to the ArrayList
     *
     * @param shape new shape object
     */
    public void addShape(Shape shape){
        shapes.add(shape);
    }

    /**
     * Retrieves and returns an ArrayList of available shapes
     *
     * @return available shapes
     */
    public ArrayList<Shape> getShapes(){
        return shapes;
    }

    /**
     * Draws available shapes. Decides whether to display shape names and/or bounding boxes
     *
     * @param graphics used for drawing the shape
     */
    public void drawShapes(Graphics graphics){
        for(Shape currentShape : shapes){
            currentShape.renderShape(graphics);
            if(displayShapeName) currentShape.displayName(graphics);
            if(displayBoundingBox) currentShape.getBoundingBox().drawBoundingBox(graphics);
        }
    }

    /**
     * Setter method for displayShapeName var
     *
     * @param state boolean
     */
    public void setDisplayName(boolean state){
        displayShapeName = state;
    }

    /**
     * Setter method for displayBoundingBox var
     *
     * @param state boolean
     */
    public void setDisplayBoundingBox(boolean state){
        displayBoundingBox = state;
    }
}
