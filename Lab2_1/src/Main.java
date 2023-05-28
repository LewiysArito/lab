import components.GraphicsPanel;
import shapes.Rectangle;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Main{
    public static void main(String[] args) {
        int width = 800;
        int height = 800;
        AtomicLong elapsedTime = new AtomicLong(0L);
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(300, 400, 50, 80, Color.red));
        rectangles.add(new Rectangle(200, 330, 70, 100, Color.blue));

        int[][] coordinate = new int[rectangles.size()][2];
        GraphicsPanel canvas = new GraphicsPanel(rectangles);
        int[][] speed = new int[rectangles.size()][2];
        rectangles.forEach(rectangle -> {
            int indexRect = rectangles.indexOf(rectangle);
            speed[indexRect][0] = (int)(Math.random()*10);
            speed[indexRect][1] = (int) (Math.random()*20-10);
        });

        Runnable circleController = () -> {
            while (true) {
                long startTime = System.currentTimeMillis();
                rectangles.forEach(rectangle1 -> {
                    int indFirstRect = rectangles.indexOf(rectangle1);
                    coordinate[indFirstRect][0] = rectangle1.getX();
                    coordinate[indFirstRect][1] = rectangle1.getY();
                    rectangle1.moveRel(speed[indFirstRect][0], speed[indFirstRect][1]);
                    for (Rectangle rectangle2 : rectangles) {
                        int indSecondRect = rectangles.indexOf(rectangle2);
                        if (indFirstRect != indSecondRect && startTime - elapsedTime.get() > 3000) {
                            int x1, x2, y1, y2, targetWidth, targetHeight;
                            if (rectangle1.getX() < rectangle2.getX()) {
                                x1 = rectangle1.getX();
                                targetWidth = rectangle1.getWidth();
                                x2 = rectangle2.getX();
                            } else {
                                x2 = rectangle1.getX();
                                targetWidth = rectangle2.getWidth();
                                x1 = rectangle2.getX();
                            }
                            if (rectangle1.getY() < rectangle2.getY()) {
                                y1 = rectangle1.getY();
                                targetHeight = rectangle1.getHeight();
                                y2 = rectangle2.getY();
                            } else {
                                y2 = rectangle1.getY();
                                targetHeight = rectangle2.getHeight();
                                y1 = rectangle2.getY();
                            }
                            int distX = x1 + targetWidth - x2;
                            int distY = y1 + targetHeight - y2;
                            if (Math.abs(distX) <= 4 &&  distY > 3 || Math.abs(distY) <= 4  && distX > 3){
                                elapsedTime.set(System.currentTimeMillis());
                                speed[indFirstRect][0] = speed[indFirstRect][0]*(-1);
                                speed[indFirstRect][1] = speed[indFirstRect][0]*(-1);
                                speed[indSecondRect][0] = speed[indSecondRect][0]*(-1);
                                speed[indSecondRect][1] = speed[indSecondRect][0]*(-1);
                            }
                        }
                    }
                });
                canvas.repaint();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.add(canvas);
        frame.setVisible(true);
        Thread animationThread = new Thread(circleController);
        animationThread.start();
    }
}