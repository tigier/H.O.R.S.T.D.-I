package Control;

import View.DrawableObject;
import View.DrawingPanel;
import View.MainFrame;

import java.awt.*;

/**
 * Created by 204g14 on 09.12.2016.
 */
public class MainController {

MainFrame frame;


    public MainController(MainFrame frame){
        this.frame = frame;
    }

    public DrawingPanel getPanel(){
        return frame.getActiveDrawingPanel();
    }
}
