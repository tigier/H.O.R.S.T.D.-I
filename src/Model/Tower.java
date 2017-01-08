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
    private int[] pos;
    private int reload;
    private boolean firstTower = true;

    static List<Enemy> EnemyList;

    private Rectangle2D rectangle;

    public Tower(int range,int x,int y, int scl,MainController controller){
        super(x,y,scl);
        this.range = range;
        this.x = x;
        this.y = y;
        createGraphics();
        pos = new int[2];
        pos[0] = x;
        pos[1] = y;
        reload = 50;
        this.controller = controller;
        firstTower();

    }

    public void firstTower(){
        if(firstTower==true){
            EnemyList = controller.getEnemyList();
            firstTower = false;
        }
    }
    public void setEnemyList(){
        if(EnemyList.isEmpty()) {
            EnemyList = controller.getEnemyList();

        }
    }

    private void createGraphics(){rectangle = new Rectangle2D.Double();}

    @Override
    public void draw(DrawingPanel dp, Graphics2D g2d) {
        g2d.setColor(new Color(212, 22, 156));
        g2d.fill(rectangle);
        g2d.setColor(new Color(0, 0, 0));
        g2d.draw(rectangle);
        rectangle.setFrame(x,y,50,50);
    }

    public void shotFire(){
        if(reload  >= 70 && target != null){
            //controller.drawShot(x,y,target.getX(),target.getY());
            if(target.getHit()){
                EnemyList.remove();
                reload = reload -50;
                controller.killedEnemy();
                target=null;
                controller.getPanel().resetIterator();
            }

        }else if(reload <90){
            reload++;
        }
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void updateEnemy() {
        int distance = range;
        EnemyList.toFirst();
        while (EnemyList.hasAccess()) {
            int xDistance = Math.abs(EnemyList.getContent().getX() - this.getX());
            int yDistance = Math.abs(EnemyList.getContent().getY() - this.getY());

            if (xDistance + yDistance < distance && xDistance + yDistance<range) {
                distance = xDistance - yDistance;
                target = EnemyList.getContent();
            }
            EnemyList.next();
        }
    }



    @Override
    public void update(double dt) {
        setEnemyList();
        updateEnemy();
        shotFire();

    }

    public static List getEnemylist(){
        System.out.print(EnemyList.isEmpty());
        return EnemyList;
    }
}
