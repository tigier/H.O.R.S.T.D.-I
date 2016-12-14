package View;

import Model.Map;

import javax.swing.*;
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
    /**
     * Konstruktor
     * @param name Der Titel des Fensters
     * @param x Die obere linke x-Koordinate des Fensters bzgl. des Bildschirms
     * @param y Die obere linke y-Koordinaite des Fensters bzgl. des Bildschirms
     * @param width Die Breite des Fensters
     * @param height Die Höhe des Fensters
     */
    public MainFrame(String name, int x, int y, int width, int height) {
        panels = new ArrayList<>();
        activePanel = new DrawingPanel();
        panels.add(activePanel);
        add(activePanel);
        addKeyListener(activePanel);
        setLocation(x,y);
        setSize(width,height);
        setTitle(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        scl = 20;
        map = new Map(activePanel.getWidth(),activePanel.getHeight());
        loadMap();

    }

    public void loadMap(){
        int[][] hmap = map.getMap();

        for(int i= 0; i< hmap.length; i++){
            for(int j= 0; j<hmap[i].length; j++){
                if(hmap[i][j] == 1){

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
