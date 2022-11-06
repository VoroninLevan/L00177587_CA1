import bounding.Point;
import guicomponents.CustomWindow;
import manager.ShapesManager;
import shapes.*;
import shapes.Rectangle;
import shapes.Shape;

import javax.swing.*;
import java.awt.*;

public class ShapeBuilder {

    public static void main(String[] args){

        //Init new ShapeManager
        ShapesManager shapesManager = new ShapesManager();
        // Init new shapes
        Shape rect = new Rectangle(Color.RED, 70, 120, 100, 200);
        Shape circle = new Circle(Color.BLUE, 100, 200, 50);
        Shape square = new Square(Color.GREEN, 300, 300, 100);
        Shape quad = new Quadrilateral(Color.MAGENTA, new Point(500, 200),
                new Point[]{new Point(440, 210), new Point(470, 240), new Point(550, 220), new Point(560, 150)});

        // Init quadrilateral out of Rectangle object
        Rectangle rect2 = new Rectangle(Color.RED, 400, 120, 50, 100);
        Shape quadRect = new Quadrilateral(rect2);

        // Add shapes to the manager list
        shapesManager.addShape(rect);
        shapesManager.addShape(circle);
        shapesManager.addShape(square);
        shapesManager.addShape(quad);
        shapesManager.addShape(quadRect);

        // Set states for display name and bounding box visibility decisions
        shapesManager.setDisplayName(true);
        shapesManager.setDisplayBoundingBox(false);

        // Init new window
        CustomWindow window = new CustomWindow(shapesManager);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("ShapeBuilder_TestAPP_CA1");
        window.setVisible(true);
    }
}
