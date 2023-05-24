package shapes;
import shapes.animator.Animator;
import shapes.animator.RectangleAnimation;

import javax.swing.*;
import java.awt.*;
public class Rectangle extends Shape{
    protected int width;
    protected  int height;

    public Rectangle(int x, int y, int width, int height, Color color){
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {return width;}

    public void setWidth(int width) {this.width = width;}

    public int getHeight() {return height;}

    public void setHeight(int height) {this.height = height;}

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawRect(x, y, width, height);
        g.fillRect(x, y, width, height);
    }
    @Override
    public Animator getAnimator(JComponent component, int delayAnimation) {
        return new RectangleAnimation(this, component, delayAnimation);
    }
}
