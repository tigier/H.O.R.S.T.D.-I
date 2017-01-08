import View.MainFrame;
import Control.MainController;
import java.awt.*;

/**
 * Created by 204g14 on 09.12.2016.
 */
public class MainProgram {
    public static void main (String[] args){
        EventQueue.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        MainProgram.setup();
                    }
                });
    }

    private static void setup(){
        new MainController(new MainFrame("Hyper Overloaded Remastered Super Tower Defense I",30,10,1010,800,50),50);
    }
}
