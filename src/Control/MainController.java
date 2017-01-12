package Control;

import Model.*;
import Model.List;
import View.DrawingPanel;
import View.MainFrame;

import javax.sound.sampled.Line;
import java.awt.*;
import java.awt.geom.Line2D;


/**
 * Created by 204g14 on 09.12.2016.
 */
public class MainController {
    private List<Enemy> EnemyList;
    private int level;
    private int scl;
    private int[] spawn;
    private MainFrame frame;
    private Map map;
    private int money;

    private int killedEnemy;

    public MainController(MainFrame frame, int scl) {
        this.frame = frame;
        map = frame.getMap();
        spawn = map.getWaypoints().top();
        this.scl = scl;
        loadLvl();
        level = 1;
        money = 100;
        frame.setController(this);

    }

    public int getMoney() {
        return money;
    }

    public void buildTower() {
        money = money - 37;
    }

    public void upgradeTower(){
        money=money-50;
    }

    public DrawingPanel getPanel() {
        return frame.getActiveDrawingPanel();
    }

    public void loadLvl() {
        if(EnemyList==null) {
            EnemyList = new List<Enemy>();
        }
        for (int i = 0; i != 20  ; i++){
            Enemy pivot = new Enemy(level*2, 3, 19+i, 5,scl);
            EnemyList.append(pivot);
            getPanel().addObject(pivot);
            killedEnemy--;
        }
        getPanel().resetIterator();
    }

    public List<Enemy> getEnemyList(){
        return EnemyList;
    }

    public void drawShot(int x1, int y1, int x2,int y2){
        getPanel().addObject(new Shot(x1,y1,x2,y2));
        frame.drawShot(x1,y1,x2,y2);
    }

    public void killedEnemy(){
            killedEnemy++;
            money = money + level*2;
            frame.updateGold();
            restartLevel();
            removeFromList();

    }

    public void removeFromList(){
        EnemyList.remove();
    }

    public void restartLevel(){
        if(killedEnemy ==0){
            level++;
            loadLvl();
            //EnemyList = null;
            //killedEnemy=0;
            getPanel().resetIterator();
            System.out.println(killedEnemy);
        }
        System.out.println(killedEnemy);
    }

}
