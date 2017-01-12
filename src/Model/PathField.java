package Model;

import View.DrawableObject;
import View.DrawingPanel;

import java.awt.*;

/**
 * Created by Jens on 14.12.2016.
 */
public class PathField extends Field  implements DrawableObject {

    /**
     * das Feld auf dem die Tower gebaut werden
     * @param x / *@param y position des Feldes
     */
    public PathField(int x, int y,int scl){
        super(x,y,scl);
    }


    @Override
    public void update(double dt) {

    }
    @Override
    public void draw(DrawingPanel dp, Graphics2D g2d) {
        g2d.setColor(new Color(58, 212, 14));
        g2d.fill(rectangle);
        g2d.setColor(new Color(47, 166, 14));
        g2d.draw(rectangle);
        rectangle.setFrame(x,y,scl,scl);

    }
}
