package Model;
import Control.MainController;
import View.DrawableObject;
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
public class Tower extends Field implements DrawableObject {

    private MainController controller;
    private Enemy target;
    private int range;
    private int x;
    private int y;
    private int reload;
    private int dmg;





    private Rectangle2D rectangle;
    /**
     * Konstruktor
     */
    public Tower(int range,int x,int y, int scl,MainController controller){
        super(x,y,scl);
        this.range = range;
        this.x = x;
        this.y = y;
        createGraphics();
        reload = 50;
        this.controller = controller;
        dmg = 1;

    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getDmg() {
        return dmg;
    }
    /**
     * nur wichtig für das zeichnen des Objekts
     */
    private void createGraphics(){rectangle = new Rectangle2D.Double();}

    public void upgrade(){
        controller.spentMoney(dmg*30);
        dmg = dmg * 2;

    }



    /**
     * wenn der Tower nachgeladen hat
     *   schießt dieser einen schuss auf das target
     *   und ruft die dafür notwendigen methoden auf
     * andernfalls erhöht er den timer
     *
     *
     */
    public void shotFire(){
        if(reload  >= 70 && target != null){
            //controller.drawShot(x,y,target.getX(),target.getY());
            if(target.getHit(dmg)){
                controller.getEnemyList().remove();
                controller.killedEnemy();
                reload = reload -70;
                target=null;
                controller.getPanel().resetIterator();
            }

        }else if(reload <90){
            reload++;
        }
    }

    /**
     * setzt ein target innerhalb der range fest
     *
     */
    public void updateEnemy() {
        int distance = range;
        controller.getEnemyList().toFirst();
        while (controller.getEnemyList().hasAccess()) {
            int xDistance = Math.abs(controller.getEnemyList().getContent().getX() - this.getX());
            int yDistance = Math.abs(controller.getEnemyList().getContent().getY() - this.getY());

            if (xDistance + yDistance < distance && xDistance + yDistance<range) {
                distance = xDistance - yDistance;
                target = controller.getEnemyList().getContent();
            }
            controller.getEnemyList().next();
        }
    }


    @Override
    public void draw(DrawingPanel dp, Graphics2D g2d) {
        g2d.setColor(new Color(232, 116, 197));
        g2d.fill(rectangle);
        g2d.setColor(new Color(256-dmg*30, 256-dmg*30,256-dmg*30));
        g2d.draw(rectangle);
        rectangle.setFrame(x,y,50,50);
    }

    @Override
    public void update(double dt) {
        updateEnemy();
        shotFire();

    }

}
