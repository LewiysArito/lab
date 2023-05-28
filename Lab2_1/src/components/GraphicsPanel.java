package components;
import shapes.Rectangle;

import javax.swing.*;
import java.util.List;
import java.awt.*;

public class GraphicsPanel extends JPanel {
    private List<Rectangle> rectangles;

    public List<Rectangle> getRectangle(){return rectangles;}
    public void setShapes(List<Rectangle> rectangles){this.rectangles = rectangles;}

    public GraphicsPanel(List<Rectangle> rectangles) {
        this.rectangles = rectangles;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Rectangle rectangle: rectangles) {
            rectangle.draw_shadow(g);
            rectangle.draw(g);
        }
    }
}
