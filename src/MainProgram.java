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
        new MainController(new MainFrame("Erste graphische Ausgabe",50,50,1100,900));
    }
}
