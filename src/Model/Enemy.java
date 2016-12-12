package Model;

import View.DrawingPanel;

import java.awt.*;

/**
 * Created by 204g14 on 09.12.2016.
 */
public class Enemy extends MovableObject{
    private int hp;
    private int speed;
    private boolean air;
    private int[] coord;


    public Enemy(int hp, int speed, int[] nextTile, int x,int y, int range){
        super(nextTile, x, y, range);
        this.hp = hp;
        this.speed = speed;
        coord = new int[2];
        coord[0]= x;
        coord[1]= y;
    }

    public int[] getCoord(){
        return coord;
    }

    @Override
    public void draw(DrawingPanel dp, Graphics2D g2d) {


    }

    @Override
    public void update(double dt) {

    }
}
