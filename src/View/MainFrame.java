package View;

import Control.MainController;
import Model.*;
import Model.List;

import javax.swing.*;
import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 * Created by Jean-Pierre on 15.11.2016.
 */
public class MainFrame extends JFrame {

    // Attribute
    private int scl;
    // Referenzen
    private DrawingPanel activePanel;
    private ArrayList<DrawingPanel> panels;
    private Map map;
    private Field[][] field;
    private MainController controller;
    private Robot robot;

    private JLabel money;


    /**
     * Konstruktor
     * @param name Der Titel des Fensters
     * @param x Die obere linke x-Koordinate des Fensters bzgl. des Bildschirms
     * @param y Die obere linke y-Koordinaite des Fensters bzgl. des Bildschirms
     * @param width Die Breite des Fensters
     * @param height Die Höhe des Fensters
     */
    public MainFrame(String name, int x, int y, int width, int height, int scl) {
        panels = new ArrayList<>();
        activePanel = new DrawingPanel();
        panels.add(activePanel);
        add(activePanel);
        activePanel.setBackground(new Color(212, 125, 31));
        addKeyListener(activePanel);

        setLocation(x,y);
        setSize(width,height);
        setTitle(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        money = new JLabel("100");
        money.setBounds(500,10,10,10);
        getActiveDrawingPanel().add(money);
        money.setVisible(true);

        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        this.scl = scl;

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                Color color = new Color(212, 125, 31);
                Color color2 = new Color(232, 116, 197);
                if(getColorAtPoint().equals(color)) {
                    if (keyEvent.getKeyCode() == KeyEvent.VK_Q && controller.getMoney() > 30) {
                        controller.spentMoney(30);
                        Tower tower = new Tower(250, getActiveDrawingPanel().getMousePosition().x / scl * scl, getActiveDrawingPanel().getMousePosition().y / scl * scl, scl, controller);
                        activePanel.addObject(tower);
                        controller.getTowerList().append(tower);
                    }
                }
                if(getColorAtPoint().equals(color2)){
                    System.out.println("test");
                    controller.getTowerList().toFirst();
                    while ((controller.getTowerList().getContent().getX() != getActiveDrawingPanel().getMousePosition().x / scl * scl || controller.getTowerList().getContent().getY() != getActiveDrawingPanel().getMousePosition().y / scl * scl) && controller.getTowerList().hasAccess()) {
                        controller.getTowerList().next();
                    }
                    Tower tower = controller.getTowerList().getContent();
                    if (keyEvent.getKeyCode() == KeyEvent.VK_Q && getColorAtPoint().equals(color2) && controller.getMoney() > tower.getDmg() * 30 && tower.getDmg() < 5) {
                        tower.upgrade();
                    }
                    System.out.println(controller.getTowerList().getContent().getDmg());
                }
                updateGold();
            }
        });

        map = new Map(activePanel.getWidth()/scl,activePanel.getHeight()/scl);
        loadMap();

    }

    public Map getMap(){
        return map;
    }

    /**
     * updated das "money" Textfeld
     */
    public void updateGold(){
        money.setText(Integer.toString(controller.getMoney()));
    }

    /**
     * malt theoretisch eine linie als Schuss von Punkt 1 zu Punkt 2
     */
    public void drawShot(int x1, int y1, int x2,int y2){
        getGraphics().drawLine(x1,y1,x2,y2);

    }

    public void setController(MainController controller){
        this.controller = controller;
    }

    /**
     * liefert mit hilfe des robots die Farbe an der derzeitigen Mausposition
     * @return
     */
    private Color getColorAtPoint() {
        if(robot != null){
            return robot.getPixelColor(MouseInfo.getPointerInfo().getLocation().x,MouseInfo.getPointerInfo().getLocation().y);
        }

        return null;
    }

    /**
     * lädt die map
     */
    public void loadMap(){

        field = new Field[activePanel.getWidth()/scl][activePanel.getHeight()/scl];
        int[][] hmap = map.getMap();

        for(int i= 0; i < hmap.length; i++){
            for(int j= 0; j < hmap[i].length; j++){
                if(hmap[i][j] == 0){
                    field[i][j]= new NormalField(i*scl,j*scl, scl);
                    activePanel.addObject(field[i][j]);
                }else if(hmap[i][j] == 1){
                    field[i][j]= new PathField(i*scl,j*scl, scl);
                    activePanel.addObject(field[i][j]);
                }
            }
        }
    }



    /**
     * Liefert das aktuell vom DrawWindow angezeigte DrawingBoard zur�ck
     * @return Das aktuelle DrawingBoard
     */
    public DrawingPanel getActiveDrawingPanel(){
        return activePanel;
    }

    /**
     * Fügt dem DrawWindow ein neues DrawingBoard hinzu. Dieses wird nicht zum
     * aktuellen DrawingBoard!
     */
    public void addNewDrawingPanel(){
        DrawingPanel tempDB = new DrawingPanel();
        panels.add(tempDB);
    }

    /**
     * Ändert das aktuell vom DrawWindow gezeigte DrawingBoard.
     * @param index Der Index des neuen zu zeigenden DrawingBoards (angefangen bei 0).
     */
    public void setActiveDrawingPanel(int index){
        if (index < panels.size()){
            remove(activePanel);
            removeKeyListener(activePanel);
            activePanel = panels.get(index);
            add(activePanel);
            revalidate();
            addKeyListener(activePanel);
        }
    }
}
