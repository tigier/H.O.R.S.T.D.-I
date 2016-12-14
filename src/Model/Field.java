package Model;

import View.DrawableObject;
import View.DrawingPanel;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by Jens on 14.12.2016.
 */
public abstract class Field implements DrawableObject{
    int x;
    int y;
    int scl;

    protected Rectangle2D.Double rectangle;

    public Field(int x, int y, int scl){
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(DrawingPanel dp, Graphics2D g2d) {
        g2d.setColor(new Color(0,255,0));
        g2d.fill(rectangle);
        g2d.setColor(new Color(240,128,128));
        g2d.draw(rectangle);
        rectangle.setFrame(x,y,scl,scl);

    }


}
