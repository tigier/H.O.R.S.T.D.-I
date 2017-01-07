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
    private Stack<int[]> waypoints;
    private int path;
    int scl;

    public Enemy(int hp, int speed, int x, int y, Stack waypoints, int scl){
        this. scl = scl;
        this.hp = hp;
        this. speed = speed;
        this.x = x*scl;
        this.y = y*scl;
        this.waypoints = waypoints;
        createGraphics();
    }

    public int[] getCoord(){
        int[] h = new int[2];
        h[0] = x;
        h[1] = y;
        return h;
    }

    private void createGraphics(){rectangle = new Rectangle2D.Double();}

    @Override
    public void draw(DrawingPanel dp, Graphics2D g2d) {
        //rectangle = new Rectangle2D.Double();

        g2d.setColor(new Color(38, 28, 212));
        g2d.fill(rectangle);
        g2d.setColor(new Color(0, 0, 0));
        g2d.draw(rectangle);
        rectangle.setFrame(x,y+scl/3,15,15);

    }


    public void move(){

        if(path< 230){
            x--;

        }else if(path < 380){
            y++;
        }else if(path < 780){
            x--;
        }else if(path < 930) {
            y--;
        }else if(path < 1500){
            x--;
        }else if(path < 2000){
            //TODO Hier muss das Programm beendet werden
            System.out.println("fertig");
        }
        path++;


    }


    @Override
    public void update(double dt) {

        for(int i = 0; i<speed ; i++){
            move();
        }


    }


}
