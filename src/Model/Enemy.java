package Model;

import View.DrawableObject;
import View.DrawingPanel;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by 204g14 on 09.12.2016.
 */
public class Enemy implements DrawableObject{

    protected Rectangle2D.Double rectangle;
    private int hp;
    private int speed;
    private int x;
    private int y;
    public boolean dead;
    private int path;
    int scl;
    private int hit;
    private int color;

    public Enemy(int hp, int speed, int x, int y, int scl){
        this. scl = scl;
        this.hp = hp;
        this.speed = speed;
        this.x = x*scl;
        this.y = y*scl;
        dead = false;
        createGraphics();
        hit= 0;
        if(hp<15) {
            color = hp*5;
        }else{
            color=hp*2;
        }
    }


    public boolean getHit(int d){
        if(hit == 0) {
            hit=20;
            this.hp = hp-d;
            if (hp <= 0) {
                dead = true;
                x = -5000;

                return true;

            }
        }
        hit--;
        return false;
    }


    private void createGraphics(){
        rectangle = new Rectangle2D.Double();

    }

    @Override
    public void draw(DrawingPanel dp, Graphics2D g2d) {
        if(dead !=true) {
            g2d.setColor(new Color(color, 15, 13));
            g2d.fill(rectangle);
            g2d.setColor(new Color(0, 0, 0));
            g2d.draw(rectangle);
            rectangle.setFrame(x, y + scl / 3, 15, 15);
        }

    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }


    public void move(){
        if(x>19*scl){
            x--;
        }else if(path< 230){
            x--;
            path++;
        }else if(path < 380){
            y++;
            path++;
        }else if(path < 780){
            x--;
            path++;
        }else if(path < 930) {
            y--;
            path++;
        }else if(path < 1500){
            x--;
            path++;
        }else if(path < 2000){
            //TODO Hier muss das Programm beendet werden
            System.out.println("fertig");
        }
    }


    @Override
    public void update(double dt) {
        if(dead == false) {
            for (int i = 0; i < speed; i++) {
                move();
            }
        }


    }


}
