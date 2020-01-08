package ru.tests.techtracker.gui;

import javax.swing.*;
import java.awt.*;

/**
 * @deprecated
 */
public class MainPaint extends JPanel {
    private String msg;
    private int x = 10;
    private int y = 100;

    public MainPaint(String msg) {
        this.msg = msg;
    }

    public MainPaint(String msg, int x, int y) {
        this.msg = msg;
        this.x = x;
        this.y = y;
    }

    public void paintComponent(Graphics g) {
        g.drawString(msg, x, y);
    }

}
