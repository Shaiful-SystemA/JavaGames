package sample;

import  java.awt.*;
import  java.awt.geom.*;

/**
 * Created by sha6 on 15/5/16.
 */
public class BreakoutShape{

    private Color color;
    private boolean fill;
    private RectangularShape shape;




    public BreakoutShape( RectangularShape shape,Color color, boolean fill) {

        this.shape = shape;
        this.color = color;
        this.fill = fill;
    }

    public Color getColor() {
        return color;
    }

    public void changeColor(Color color){

        this.color=color;
    }

    public void draw(Graphics2D g2)
    {

        g2.setPaint(color);
        g2.draw(shape);
        if(fill){
            g2.fill(shape);
        }
    }


    public double getX(){
        return shape.getX();
    }

    public  double getY(){
        return shape.getY();
    }

    public double getHeight(){
        return shape.getHeight();
    }

    public double getWidth(){
        return shape.getWidth();
    }

    public void move(int dx, int dy){
        shape.setFrame(getX() + dx, getY() + dy,getWidth(), getHeight());
    }

//
//
//    public void setColor(Color color) {
//        this.color = color;
//    }
//
//    public boolean isFill() {
//        return fill;
//    }
//
//    public void setFill(boolean fill) {
//        this.fill = fill;
//    }
//
//    public RectangularShape getShape() {
//        return shape;
//    }
//
//    public void setShape(RectangularShape shape) {
//        this.shape = shape;
//    }


}
