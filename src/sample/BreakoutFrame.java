package sample;


import javax.swing.*;
import  java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import  java.awt.geom.*;


/**
 * Created by sha6 on 15/5/16.
 */
public class BreakoutFrame extends JFrame {

    private  static final int HEIGHT = 600;
    private static final int WIDTH = 488;

    private BreakoutPanel panel = new BreakoutPanel();

    public BreakoutFrame(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocation(100,100);
        setSize(WIDTH,HEIGHT);
        add(panel);
        setResizable(false);

    }

    public void displayMenu(){

        JMenuBar menuBar =  new JMenuBar();
        menuBar.add(new GameMenu());
        menuBar.add(new ColorMenu());
        menuBar.add(new SpeedMenu());
        setJmenuBar(menuBar);

    }

    private class GameMenu extends JMenu{

        public GameMenu(){

            super("Game");
            JMenuItem startGameMI =  new JMenuItem("Start", 'S');
            startGameMI.setAccelerator((KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK)));
            JMenuItem pauseMI = new JMenuItem("Pause",'P');
            pauseMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
            JMenuItem quitMI = new JMenuItem("Quit");
            startGameMI.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel.start;
                }
            });

            pauseMI.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel.pause;
                }
            });

            quitMI.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

            add(startGameMI);
            add(pauseMI);
            add(quitMI);


        }
    }

    private class ColorMenu extends JMenu{

        public ColorMenu(){
            super("Ball Color");
            for(BallColor color: BallColor.value()){
                JMenuItem menuItem = new JMenuItem(color.name() + "Ball");
                menuItem.addActionListener(new BallColorListener(color));
                add(menuItem);
            }
        }

    }

    private  class BallColorListener implements ActionListener{
        private BallColor color;

        public  void actionPerformed(ActionListener e){
            panel.changeBallColor(color);
        }
        public BallColorListener(BallColor color){
            this.color = color;
        }

    }

    private class SpeedMenu extends JMenu{
        public SpeedMenu(){
            super("Ball Speed");
            for(BallSpeed s:BallSpeed.value()){
                JMenuItem  menuItem = JMenuItem(s.name());
                menuItem.addActionListener(new BallSpeedListener(s.speed()));
                add(menuItem);
            }
        }
    }

    private class BallSpeedListener implements ActionListener{
        private int speeed;
        public void actionPerformed(ActionEvent e){
            panel.changeBallSpeed(speed);
        }
        public BallSpeedListener(int speed){
            this.speed = speed;
        }
    }



























}
