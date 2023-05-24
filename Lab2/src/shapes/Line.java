package shapes;

import shapes.animator.Animator;
import shapes.animator.LineAnimation;

import javax.swing.*;
import java.awt.*;

public class Line extends Shape {

    protected int dx;
    protected int dy;
    protected int x1;
    protected int y1;

    public Line(int x, int y, int dx, int dy, Color color) {
        super(x, y, color);
        this.dx = dx;
        this.dy = dy;
        this.x1 = x + dx;
        this.y1 = y + dy;

    }

    public int getDx() {return dx;}

    public void setDx(int dx) {this.dx = dx;}

    public int getDy() {return dy;}

    public void setDy(int dy) {this.dy = dy;}

    public int getX1() {return x1;}

    public void setX1() {this.x1 = x + dx;}


    public int getY1() {return y1;}

    public void setY1() {this.y1 = y + dy;}

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawLine(x, y, x1, y1);
    }

    @Override
    public void moveTo(int x, int y){
        super.moveTo(x, y);
        this.x1 = x + dx;
        this.y1 = y + dy;
    }

    @Override
    public Animator getAnimator(JComponent component, int delayAnimation) {
        return new LineAnimation(this, component, delayAnimation);
    }
}
