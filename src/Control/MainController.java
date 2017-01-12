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

    private List<Tower> towerList = new List<Tower>();

    /**
     * Konstruktor
     */
    public MainController(MainFrame frame, int scl) {
        this.frame = frame;
        map = frame.getMap();
        spawn = map.getWaypoints().top();
        this.scl = scl;
        loadLvl();
        level = 1;
        money = 10000;
        frame.setController(this);
        towerList = new List<>();

    }

    public List<Tower> getTowerList(){
        return towerList;
    }

    public int getMoney() {
        return money;
    }

    public List<Enemy> getEnemyList(){
        return EnemyList;
    }

    /**
     * Eine billige verkürzung für das ActiveDrawingPanel des Frames
     */
    public DrawingPanel getPanel() {
        return frame.getActiveDrawingPanel();
    }

    /**
     * Verringert den Geldwert um den preis x
     */
    public void spentMoney(int x){
        money=money-x;
    }

    /**
     * erstellt 20 neue Enemys mit HP entsprechend des Levels in einer reihe gestaffelt außerhalb des Bildes
     */
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

    /**
     * Erstellt eineen Schuss von dem Punkt P1(x1|y1)zu P2(x2|y2)
     */
    public void drawShot(int x1, int y1, int x2,int y2){
        getPanel().addObject(new Shot(x1,y1,x2,y2));
        frame.drawShot(x1,y1,x2,y2);
        //// TODO: 12.01.2017 mach funktionierend!!
    }

    /**
     * erhöt das geld um den Wert eines Gegners und updatet danach alle notwendigen dinge
     * "Update Methode" des Maincontrollers
     */
    public void killedEnemy(){
            killedEnemy++;
            money = money + level*4;
            frame.updateGold();
            restartLevel();
            removeFromList();

    }

    /**
     * löscht das Aktuelle objekt der Enemy list damit es nichtmehr anvisiert wird
     */
    public void removeFromList(){
        EnemyList.remove();
    }

    /**
     * startet den Level neu wenn alle gegner besiegt wurden
     */
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
