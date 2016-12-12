package Model;
import Control.MainController;
import View.DrawingPanel;
import View.InteractableObject;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by 204g14 on 09.12.2016.
 */
public class Tower implements InteractableObject {
    private List<Shot> shots;
    private MainController controler;
    private Enemy target;
    private Map map;
    private int range;
    private int x;
    private int y;

    public Tower(int range,int x,int y){
        this.range = range;
        shots = new List<>();
        this.x = x;
        this.y = y;
    }

    public void shotFire(Shot pShot){
        shots.append(new Shot(target.getCoord(), getX(), getY(), range));
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
    public void draw(DrawingPanel dp, Graphics2D g2d) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void update(double dt) {

    }

    @Override
    public void keyPressed(int key) {

    }

    @Override
    public void keyReleased(int key) {

    }
}
