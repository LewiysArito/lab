package shapes.animator;

import javax.swing.*;

import shapes.Shape;

public class LineAnimation extends Animator {
    public LineAnimation(Shape shape, JComponent component, int delayAnimation) {
        super(shape, component, delayAnimation);
    }

    @Override
    public void run() {
        while (true) {
            shape.moveTo((int) (Math.random() * 600), (int) (Math.random() * 600));
            if (component != null) {
                component.repaint();
            }
            try {
                Thread.sleep(delayAnimation);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
