package sample;


import javax.swing.*;
import javax.awt.*;
import javax.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RectangularShape;


/**
 * Created by sha6 on 15/5/16.
 */
public class Paddle extends BreakoutShape {


    public Paddle(Color color, BreakoutPanel panel) {
        super(new Rectangle2D.Double(START_X,Paddle.START_Y, Paddle.WIDTH,Paddle.HEIGHT),color, true);
        this.panel = panel;
    }

    private static final int START_X = 200;
    private static final int START_Y=430;
    private static final int WIDTH = 50;
    private static final int HEIGHT = 10;
    private static final int SPEED = 10;

    private BreakoutPanel panel;


    public void move(int dx{
        if((getX()+dx>=0 && (getX()+dx+WIDTH<=panel.getWidth()))
                ){
            move(dx,0);
        }
    }

    public void moveRight(){
        move(SPEED);
    }
    public void moveLeft(){
        move(-SPEED);
    }


//    public Paddle(Color color, BreakoutPanel panel){
//        super(new Rectangle2D.Double(START_X,Paddle.START_Y, Paddle.WIDTH))
//    }

}
