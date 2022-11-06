package guicomponents;

import manager.ShapesManager;
import shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * <h1>CustomPanel</h1>
 * <p>Extends JPanel. Is a wrapper class with extended behavior<br>
 * Used to initially paint shapes on canvas, listen for mouse click events and repaint when necessary<br>
 * Maintains instance of ShapesManager to access available shapes. Being a panel used within CustomWindow.</p>
 *
 * @author Levan.Voronin
 * @version 1.0.0
 * @see ShapesManager
 * @see CustomWindow
 */
public class CustomPanel extends JPanel {

    /**Stores ShapesManager instance*/
    private final ShapesManager shapesManager;

    /**Stores available shapes*/
    private final ArrayList<Shape> shapes;

    /**
     * Constructor to initialize new object of a class
     *
     * @param shapesManager manager class storing,maintaining available shapes
     */
    public CustomPanel(ShapesManager shapesManager){
        this.shapesManager = shapesManager;
        shapes = shapesManager.getShapes();
        addMouseListener();
    }

    /**
     * Adds new mouse listener to the class, in order to register mouse click events.<br>
     * Contains logic to identify left and right mouse click events
     */
    private void addMouseListener(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                for(Shape shape : shapes){
                    if(shape.getBoundingBox()==null) continue;
                    if(e.getButton() == MouseEvent.BUTTON1 && shape.getBoundingBox().isWithinBounds(e)){
                        shape.updateFilled();
                    } else if(e.getButton() == MouseEvent.BUTTON3 && shape.getBoundingBox().isWithinBounds(e)){
                        shape.performSpecialAction();
                    }
                }
                repaint();
            }
        });
    }

    /**
     * Paints available shapes on canvas by calling ShapesManager draw method
     *
     * @param graphics the <code>Graphics</code> object to protect
     */
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        shapesManager.drawShapes(graphics);
    }


}
