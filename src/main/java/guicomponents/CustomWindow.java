package guicomponents;

import constant.Constants;
import manager.ShapesManager;

import javax.swing.*;
import java.awt.*;

/**
 * <h1>CustomWindow</h1>
 * <p>Extends JFrame. Is a wrapper class. Maintains own CustomPanel instance</p>
 *
 * @author Levan.Voronin
 * @version 1.0.0
 * @see CustomPanel
 */
public class CustomWindow extends JFrame {

    private final CustomPanel panel;

    public CustomWindow(ShapesManager shapesManager){
        panel = new CustomPanel(shapesManager);

        add(panel, BorderLayout.CENTER);

        setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
    }
}
