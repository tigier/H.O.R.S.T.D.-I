package Model;

import View.DrawableObject;
import View.DrawingPanel;

import java.awt.*;

/**
 * Created by Jens on 14.12.2016.
 */
public class PathField extends Field  implements DrawableObject {

    public PathField(int x, int y,int scl){
        super(x,y,scl);
    }


    @Override
    public void update(double dt) {

    }
}
