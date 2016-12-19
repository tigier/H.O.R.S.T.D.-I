package Model;

import View.DrawableObject;
import View.DrawingPanel;


import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by 204g14 on 09.12.2016.
 */


public class Shot implements DrawableObject {
    private int[] target;
    private Ellipse2D.Double shell;
    int x;
    int y;
    public Shot(int[] target,int x,int y, int range){


    }

    @Override
    public void draw(DrawingPanel dp, Graphics2D g2d) {
        shell = new Ellipse2D.Double(x,y,5,5);
        g2d.fill(shell);
        g2d.setColor(new Color(0, 0, 0));

    }

    @Override
    public void update(double dt){

    }

    public void missionAccomplished(){

    }
}
