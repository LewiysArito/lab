package shapes;

import javax.swing.*;
import java.awt.*;
public class Rectangle{
    protected int x;
    protected  int y;
    protected Color color;
    protected int width;
    protected  int height;
    protected static final Color shadow = Color.BLACK;

    public Rectangle(int x, int y,int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public int getX() {return x;}

    public void setX(int x) {this.x = x;}

    public int getY() {return y;}

    public void setY(int y) {this.y = y;}

    public Color getColor() {return color;}

    public void setColor(Color color) {this.color = color;}

    public void moveRel(int dx, int dy){
        x += dx;
        y += dy;
    }
    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getWidth() {return width;}

    public void setWidth(int width) {this.width = width;}

    public int getHeight() {return height;}

    public void setHeight(int height) {this.height = height;}
    public void draw_shadow(Graphics g){
        g.setColor(shadow);
        for(int i = 1; i < 6; i++){
            g.drawRect(x+i, y-i, width, height);
            g.fillRect(x+i, y-i, width, height);
        }
    }
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawRect(x, y, width, height);
        g.fillRect(x, y, width, height);

    }
}
