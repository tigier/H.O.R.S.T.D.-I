package Model;

import View.DrawableObject;
import View.DrawingPanel;

import java.awt.*;

/**
 * Created by Jens on 14.12.2016.
 */
public class NormalField extends Field implements DrawableObject {

    public NormalField(int x, int y,int scl){
        super(x,y, scl);
    }


    @Override
    public void draw(DrawingPanel dp, Graphics2D g2d) {

    }

    @Override
    public void update(double dt) {

    }
}
