package Model;

import View.DrawableObject;
import View.DrawingPanel;

import java.awt.*;

/**
 * Created by Jens on 14.12.2016.
 */
public class NormalField extends Field implements DrawableObject {


    /**
     * das Feld auf dem die Tower gebaut werden
     * @param x / *@param y position des Feldes
     */
    public NormalField(int x, int y,int scl){
        super(x,y, scl);
    }


    @Override
    public void draw(DrawingPanel dp, Graphics2D g2d) {
        g2d.setColor(new Color(212, 125, 31));
        g2d.fill(rectangle);
        g2d.setColor(new Color(80, 80, 80));
        g2d.draw(rectangle);
        rectangle.setFrame(x,y,scl,scl);
    }

    @Override
    public void update(double dt) {

    }
}
