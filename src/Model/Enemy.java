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
    private int direction;
    int scl;

    public Enemy(int hp, int speed, int x, int y, Stack waypoints, int scl){
        this. scl = scl;
        this.hp = hp;
        this. speed = speed;
        this.x = x*scl;
        this.y = y*scl;
        this.waypoints = waypoints;
    }

    public int[] getCoord(){
        int[] h = new int[2];
        h[0] = x;
        h[1] = y;
        return h;
    }

    @Override
    public void draw(DrawingPanel dp, Graphics2D g2d) {
        rectangle = new Rectangle2D.Double();
        g2d.setColor(new Color(38, 28, 212));
        g2d.fill(rectangle);
        g2d.setColor(new Color(0, 0, 0));
        g2d.draw(rectangle);
        rectangle.setFrame(x,y,10,10);

    }

    public void checkDirection(){
        if(waypoints.top()[0]>x){
            direction = 0;
        }else if(waypoints.top()[1] > y){
            direction = 1;
        }else if(waypoints.top()[0] < x){
            direction = 2;
        }else if(waypoints.top()[1] < y){
            direction = 3;
        }
    }

    public void move(){
        checkDirection();

        if(direction == 0){
            x =+ speed;
        }else if(direction == 1){
            y =+ speed;
        }else if(direction == 2){
            x =- speed;
        }else if(direction == 3){
            y =- speed;
        }


    }

    public void checkWaypoints(){
        if(this.x ==waypoints.top()[0] && this.y ==waypoints.top()[1]){
            waypoints.pop();
        }

        if(waypoints.top()== null){
            //TODO Hier muss das Programm beendet werden
        }
    }

    @Override
    public void update(double dt) {
        checkWaypoints();
        move();

    }


}
