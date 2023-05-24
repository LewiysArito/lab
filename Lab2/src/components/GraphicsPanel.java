package components;
import shapes.Shape;

import javax.swing.*;
import java.util.List;
import java.awt.*;

public class GraphicsPanel extends JPanel {
    private List<Shape> shapes;

    public List<Shape> getShapes(){return shapes;}
    public void setShapes(List<Shape> shapes){this.shapes = shapes;}

    public GraphicsPanel(List<Shape> shapes) {
        this.shapes = shapes;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape: shapes) {
            shape.draw(g);
        }
    }
}
