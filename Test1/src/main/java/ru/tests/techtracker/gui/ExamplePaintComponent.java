package ru.tests.techtracker.gui;

import javax.swing.*;
import java.awt.*;

/**
 * @deprecated
 */
public class ExamplePaintComponent extends JComponent {
    public static final int MESSAGE_X = 75;
    public static final int MESSAGE_Y = 100;
    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;

    @Override
    public void paintComponent(Graphics g) {
        g.drawString("Testing paintCompanenet()", MESSAGE_X, MESSAGE_Y);
    }

    @Override
    public Dimension getPreferredSize() {
//        return super.getPreferredSize();
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
