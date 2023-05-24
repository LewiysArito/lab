import components.GraphicsPanel;
import shapes.Line;
import shapes.Shape;
import shapes.Circle;
import shapes.Rectangle;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(200, 500, 100, Color.YELLOW));
        shapes.add(new Line(200, 150, 100, 100, Color.RED));
        shapes.add(new Rectangle(600, 600, 50, 80, Color.BLUE));

        GraphicsPanel canvas = new GraphicsPanel(shapes);

        for (Shape s: shapes) {
            Thread t = new Thread(s.getAnimator(canvas, 400));
            t.start();
        }

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.add(canvas);
        frame.setVisible(true);

    }
}