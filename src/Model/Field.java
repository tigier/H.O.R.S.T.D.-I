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
    /**
     * Konstruktor
     */
    public Field(int x, int y, int scl){
        this.x = x;
        this.y = y;
        this.scl = scl;
        rectangle = new Rectangle2D.Double();
    }




}
