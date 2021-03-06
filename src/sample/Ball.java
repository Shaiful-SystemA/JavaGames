package sample;

import  java.awt.*;
import  java.awt.geom.*;
//import  BreakoutShape;


/**
 * Created by sha6 on 15/5/16.
 */
public class Ball extends BreakoutShape {

    private static  final   int SIZE=10;
    private static final    int START_X=200;
    private static final    int START_Y=400;

    private int dx =1;
    private int dy = -1;
    private BreakoutPanel panel;

    public Ball(Color color, BreakoutPanel panel){
        super(new Ellipse2D.Double(Ball.START_X, Ball.START_Y, Ball.SIZE, Ball.SIZE),color, true);
        this.panel=panel;
    }

    private Ball(Color color, Ellipse2D.Double  ellipse){
        super(ellipse,color.true);
    }

    public Ball getVirtualBall(){
        return new Ball(super.getColor(), new Ellipse2D().Double(getX()+dx, getY()+dy,SIZE,SIZE));
    }


    public void move() {
        if (getX() + dx<0){
            dx=1;
        }
        if(getX() + getWidth() + dx>panel.getWidth()){
            dx=-1;
        }
        if(getY() + dy<0){
            dy=1;
        }
        if(getY()+getHeight()+dy >panel.getHeight()){
            dy=-1;
        }
        super.move(dx,dy);
    }

    public void goUp(){
        dy=-1;
    }

    public void goDown(){
        dy=1;
    }

    public void goLeft(){
        dy=-1;
    }

    public void goRight(){
        dy=-1;
    }
}






























