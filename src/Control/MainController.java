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
    private int level;
    private int scl;
    private int[] spawn;
    private MainFrame frame;
    private Map map;




    public MainController(MainFrame frame,int scl){
        this.frame = frame;
        map = frame.getMap();
        spawn = map.getWaypoints().top();
        this.scl= scl;
        loadLvl();
        level = 10;




    }

    public DrawingPanel getPanel(){
        return frame.getActiveDrawingPanel();
    }

    public void loadLvl(){
        EnemyQueue = new Queue<>();

        for(int i= 0 ;i< 50;i++) {

            if((i%10) == 1){
                EnemyQueue.enqueue(new Enemy(5, 1, 19, 5, map.getWaypoints(), scl));
                getPanel().addObject(EnemyQueue.front());
            }
        }

    }
}
