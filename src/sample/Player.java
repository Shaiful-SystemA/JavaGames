package sample;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.awt.*;
import javax.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RectangularShape;
import java.io.File;


/**
 * Created by sha6 on 15/5/16.
 */
public class Player {

    private static int ININTAL_NUM_LIVES = 3;
    private static int IMAGE_Y_POSITION = 450;
    private static int IMAGE_H_GAP = 5;

    public Player(){
        this.numLives = ININTAL_NUM_LIVES;
    }

    public void KillPlaoyer(){
        numLives--;
    }
    public boolean isAlive(){
        return (numLives >0);
    }

    public void draw(Graphics2D g2){
        try{

            Image image = ImageIO.read(new File("Player.gif"));
            for(int x = 0; x< numLives; x++){
                g2.drawImage(image, x*(image.getWidth(null)) + IMAGE_H_GAP ),
                        IMAGE_Y_POSITION, NULL);
            }

        } catch(Exception newException){

        }
    }
}
