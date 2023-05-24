package shapes.animator;

import shapes.Shape;

import javax.swing.*;

public class CircleAnimation extends Animator{

    public CircleAnimation(Shape shape, JComponent component, int delayAnimation) {
        super(shape, component, delayAnimation);
    }

    @Override
    public void run() {
        while (true) {
            shape.moveRel((int) (Math.random() * 10), (int) (Math.random() * 10));
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
