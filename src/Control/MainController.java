package Control;

import Model.Enemy;
import Model.Map;
import Model.Queue;
import View.DrawingPanel;
import View.MainFrame;


/**
 * Created by 204g14 on 09.12.2016.
 */
public class MainController {
private Queue<Enemy> EnemyQueue;
private int scl;
private int[] spawn;
MainFrame frame;
Map map;

    public MainController(MainFrame frame,int scl){
        this.frame = frame;
        map = frame.getMap();
        spawn = map.getWaypoints().top();
        this.scl= scl;
        loadLvl();


    }

    public DrawingPanel getPanel(){
        return frame.getActiveDrawingPanel();
    }

    public void loadLvl(){
        EnemyQueue = new Queue<>();
        EnemyQueue.enqueue(new Enemy(5,1, map.getWaypoints().top()[0],map.getWaypoints().top()[1], map.getWaypoints(), scl));
        EnemyQueue.enqueue(new Enemy(5,1, map.getWaypoints().top()[0],map.getWaypoints().top()[1], map.getWaypoints(), scl));
        getPanel().addObject(EnemyQueue.front());
    }


}
