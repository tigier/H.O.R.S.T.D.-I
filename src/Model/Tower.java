package Model;
import Control.MainController;

/**
 * Created by 204g14 on 09.12.2016.
 */
public class Tower {
    private Shot shot;
    private MainController controler;
    private Enemy target;
    private Map map;
    private int range;

    public Tower(int range){
        this.range = range;
    }

    public void shotsFired(Shot pShot){

    }
}
