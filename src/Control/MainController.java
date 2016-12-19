package Control;

import Model.Enemy;
import Model.Queue;
import View.DrawingPanel;
import View.MainFrame;

import java.awt.event.WindowEvent;


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
        spawn[1] = 4;

        this.scl= scl;
        loadLvl();

    }

    public DrawingPanel getPanel(){
        return frame.getActiveDrawingPanel();
    }

    public void close(){
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }

    public void loadLvl(){
        EnemyQueue = new Queue<>();
        EnemyQueue.enqueue(new Enemy(5,5, false, spawn[0]*scl, spawn[1]*scl+scl/2-5, scl, this));
        getPanel().addObject(EnemyQueue.front());
    }
}
