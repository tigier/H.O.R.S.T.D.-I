package Control;

import Model.Enemy;
import Model.List;
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
        EnemyQueue = new Queue<Enemy>();


    }

    public DrawingPanel getPanel(){
        return frame.getActiveDrawingPanel();
    }

    public void loadLvl(){

        for(int i= 0; i<5 ; i++){
            EnemyQueue.enqueue(new Enemy(5,1, map.getWaypoints().top()[0],map.getWaypoints().top()[1]-i*5, map.getWaypoints(), scl));
        }

        while(EnemyQueue.front() != null){
            getPanel().addObject(EnemyQueue.front());
            EnemyQueue.dequeue();
        }


    }


}
