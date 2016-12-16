package Control;

import Model.Enemy;
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


    public MainController(MainFrame frame,int scl){
        this.frame = frame;
        spawn = new int[2];
        spawn[0] = 19;
        spawn[1] = 5;
        this.scl= scl;
        loadLvl();

    }

    public DrawingPanel getPanel(){
        return frame.getActiveDrawingPanel();
    }

    public void loadLvl(){
        EnemyQueue = new Queue<>();
        EnemyQueue.enqueue(new Enemy(5,2,spawn, false, spawn[0], spawn[1], scl));
        frame.getActiveDrawingPanel().addObject(EnemyQueue.front());
    }
}
