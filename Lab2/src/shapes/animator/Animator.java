package shapes.animator;

import shapes.Shape;

import javax.swing.*;

public abstract class Animator implements Runnable{
    protected Shape shape;
    protected JComponent component;
    protected int delayAnimation;
    public Animator(Shape shape, JComponent component, int delayAnimation){
        this.shape = shape;
        this.component = component;
        this.delayAnimation =  delayAnimation;

    }
}
