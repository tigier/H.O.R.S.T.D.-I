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
        hit= 0;

        color = hp*20;
        while(color > 254 ){
            color--;
        }

        createGraphics();
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    /**
     * nur wichtig für das zeichnen des Objekts
     */
    private void createGraphics(){
        rectangle = new Rectangle2D.Double();

    }


    /**
     * setzt den "Timer" für das getroffen werde zurück
     * verringert das Leben
     * und "stirbt" ggf
     * wenn es kurz vorher angegriffen wurde erhöht es nur den timer
     * @return der return ist wichtig für den MainController ob ein gegner gestorben ist
     */
    public boolean getHit(int dmg){
        if(hit == 0) {
            hit=20;
            this.hp = hp-dmg;
            if (hp <= 0) {
                dead = true;
                x = -5000;

                return true;

            }
        }
        hit--;
        return false;
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

    @Override
    public void update(double dt) {
        if(dead == false) {
            for (int i = 0; i < speed; i++) {
                move();
            }
        }


    }

    /**
     * bewegt das Objekt entlang des Weges weiter
     * ja es ist eine blöde Lösung aber sie Funktioniert
     */
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
            System.out.println("Sorry You Lost");
                    System.exit(1);
        }
    }

}
