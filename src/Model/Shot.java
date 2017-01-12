package Model;

import View.DrawableObject;
import View.DrawingPanel;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by Jens on 08.01.2017.
 */
public class Shot implements DrawableObject {
    int n;
    private Line2D line2D;

    /**
     * der Schuss soll eig. durch eine Linie vom Turm zum gegner dargestellt werden funktioniert allerdings nur begrenzt
     */
    public Shot(int x1, int y1, int x2,int y2) {
        n=0;
        line2D = new Line2D.Double(x1,y1,x2,y2);
    }
    @Override
    public void update(double dt) {
        if(n<=30){
            n++;
            if(n==30){
                this.n=100;
            }
        }
    }

    @Override
    public void draw(DrawingPanel dp, Graphics2D g2d) {
        if(n<30) {
            g2d.setColor(new Color(212, 7, 182));
            g2d.fill(line2D);
            g2d.setColor(new Color(0, 0, 0));
            g2d.draw(line2D);
        }

    }


}
