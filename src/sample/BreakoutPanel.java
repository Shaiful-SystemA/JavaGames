package sample;

import javax.swing.*;
import javax.awt.*;
import javax.awt.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;


/**
 * Created by sha6 on 15/5/16.
 */
public class BreakoutPanel extends JPanel{

    private javax.swing.Timer timer;
    private Ball ball;
    private Paddle paddle;

    private Player player =  new Player();

    public BreakoutPanel(){
        ball = new Ball(Color.RED, this);
        paddle = new Paddle(Color.BLUE, this);
        timer =  new javax.swing.Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ball.move();
                repaint();
            }
        });

        timer.start();
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if(e.getKeyCode()==keyEvent.VK_LEFT){
                    paddle.moveLeft();
                }

                if(e.getKeyCode()==keyEvent.VK_RIGHT){
                    paddle.moveRight();
                }
                repaint();

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });


        addMouseMotionListener(new MouseMotionAdapter() {
            boolean firsTime = true;
            int oldX;

            @Override
            public void mouseMOved(MouseEvent e) {
            if (firsTime){
                oldX = e.getX();
                firsTime = false;
            }
            paddle.move(e.getX()-oldX);
            oldX = e.getX();
            repaint();

            }
        });

        setFocusable(true);

        timer = new javax.swing.Timer(10, new TimerListener());

        class TimerListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                Ball newBall = ball.getVirtualBall();
                if(newBall.intersects(paddle)){
                    ball.goUp();
                    if(newBall.getY() + newBall.getWidth() / 2 <paddle.getY()+ paddle.getWidth()/2){
                        ball.goLeft();
                    }
                }else{
                    ball.goRight();
                }
            } else if (ball.getY()> paddle.getY() - paddle.getHeight()){
                System.exit(0);
            }
            ball.move();
            repaint();

        }

    }


    public  void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D) g;
        ball.draw(g2);
        paddle.draw(g2);
    }

    public boolean intersects(BreakoutShape other){
        return shape.intersects(other.shape.getBounds());
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!player.isAlive()) {
            showMessage("Game Over!", g2);
            return;
            player.draw(g2);
            ball.draw(g2);
            paddle.draw(g2);

        }
    }

    public void showMessage(String s, Graphics2D g2) {

        Font myFont = new Font("SansSerif", Font.BOLD + Font.ITALIC,40);
        g2.setFont(myFont);
        g2.setColor(Color.RED);
        Rectangle2D textBox = myFont.getStringBounds(s,g2.getFontRenderContext());
        g2.drawString(s,(int)(getWidth()/2-textBox.getWidth()/2),(int)(getHeight()/2-textBox.getHeight()));

    }



    class TimeListerner implements ActionListener{

        public void actionPerformed(ActionEvent e){

            Ball newBAll = ball.getVirtualBall();
            if(newBAll.intersects(paddle)){
                ball.goUp();
             if(newBAll.getX() - newBAll.getWidth()/ 2<paddle.getX() + paddle.getWidth()/2){
                 ball.goLeft();
             }else{
                 ball.goRight();
             }
            }else if (ball.getY() > paddle.getY() - paddle.getHeight()){
                ball.goUp();
                player.killPlayer();
            }
            ball.move();
            repaint();

        }
    }

    }












