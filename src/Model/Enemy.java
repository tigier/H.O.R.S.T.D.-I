package Model;

import View.DrawingPanel;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by 204g14 on 09.12.2016.
 */
public class Enemy extends MovableObject{
    private int hp;
    private int speed;
    private boolean air;
    private int[] coord;
    private int[] nextTile;
    protected Rectangle2D.Double rectangle;


    public Enemy(int hp, int speed, int[] nextTile, boolean air, int x,int y, int scl){
        super(nextTile, x, y, scl/2);
        this.hp = hp;
        this.speed = speed;
        coord = new int[2];
        coord[0]= x;
        coord[1]= y;
        this.air = air;
        this.nextTile = nextTile;


    }

    public int[] getCoord(){
        return coord;
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

    @Override
    public void update(double dt) {
        //move();
        //missionAccomplished();
    }

    public void missionAccomplished(){
        if(this.x - range == 0 && this.y - range == 0){

        }

    }
}
