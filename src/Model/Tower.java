package Model;
import Control.MainController;
import View.DrawingPanel;
import View.InteractableObject;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by 204g14 on 09.12.2016.
 */
public class Tower extends Field implements InteractableObject {

    private MainController controler;
    private Enemy target;
    private int range;

    private Rectangle2D rectangle;

    public Tower(int range,int x,int y, int scl){
        super(x,y,scl);
        this.range = range;
        this.x = x;
        this.y = y;
    }

    private void createGraphics(){rectangle = new Rectangle2D.Double();}

    @Override
    public void draw(DrawingPanel dp, Graphics2D g2d) {
        g2d.setColor(new Color(212, 0, 28));
        g2d.fill(rectangle);
        g2d.setColor(new Color(0, 0, 0));
        g2d.draw(rectangle);

    }

    public void shotFire(){
        // er malt eine linie zum gegener

    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void updateEnemy(){

    }


    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void update(double dt) {
        rectangle.setFrame(x,y,50,50);
        updateEnemy();

    }

    @Override
    public void keyReleased(int key) {

    }

    @Override
    public void keyPressed(int key) {

    }
}
