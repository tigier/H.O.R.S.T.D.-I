package Model;

import Control.MainController;
import View.DrawableObject;
import View.DrawingPanel;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by 204g14 on 09.12.2016.
 */
public class Enemy implements DrawableObject{
    private int hp;
    private int speed;
    private boolean air;
    private int x;
    private int y;
    private int direction;
    private MainController controller;

    protected Rectangle2D.Double rectangle;


    public Enemy(int hp, int speed, boolean air, int x, int y, int scl, MainController controller){
        this.controller= controller;
        this.hp = hp;
        this.speed = speed;
        this.x = x;
        this.y = y;
        this.air = air;

        direction = 3;
        rectangle = new Rectangle2D.Double();

    }

    @Override
    public void draw(DrawingPanel dp, Graphics2D g2d) {

        g2d.setColor(new Color(38, 28, 212));
        g2d.fill(rectangle);
        g2d.setColor(new Color(0, 0, 0));
        g2d.draw(rectangle);
        rectangle.setFrame(x,y,10,10);

    }

    @Override
    public void update(double dt) {
        move();
        checkFinish();

    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void checkFinish() {
       if(this.getX()< -10){
            controller.close();
       }
    }

    public void move(){

        if(direction == 0){
            y-= speed;
        }else if(direction == 1){
            x+= speed;
        }else if(direction == 2){
            y+= speed;
        }else if(direction == 3){
            x-= speed;
        }
    }

}
