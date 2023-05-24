package shapes;


import shapes.animator.Animator;
import shapes.animator.CircleAnimation;

import java.awt.*;
import javax.swing.*;

public class Circle extends Shape{
    protected int radius;

    public Circle(int x, int y, int radius, Color color){
        super(x, y, color);
        this.radius = radius;
    }

    public int getRadius() {return radius;}

    public void setRadius(int radius) {this.radius = radius;}
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawOval(x, y, radius, radius);
        g.fillOval(x, y, radius, radius);
    }
    @Override
    public Animator getAnimator(JComponent component, int delayAnimation) {
        return new CircleAnimation(this, component, delayAnimation);
    }
}
