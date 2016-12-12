package Model;


import View.DrawableObject;
import View.DrawingPanel;

import java.awt.*;

/**
 * Created by 204g13 on 12.12.2016.
 */
public abstract class MovableObject implements DrawableObject {
    int tx;
    int ty;
    int x;
    int y;
    int range;
    DrawingPanel panel;
    Graphics2D graphics2D;


    public MovableObject(int[] target, int x , int y, int range){
        tx = target[0];
        ty = target[1];
        this.x  = x;
        this.y = y;
        this.range = range;

    }

    public void move(){
        int s = x+(tx-x)/range;
        int r = y+(ty-y)/range;
    }


}
