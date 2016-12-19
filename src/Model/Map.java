package Model;

/**
 * Created by 204g14 on 09.12.2016.
 */
public class Map {
    private int[][] map;

    /**
     * map:
     * wert Feld
     * 0    normales Feld
     * 1    gegner Weg
     * 2    Tower
     * @param x
     * @param y
     */
    public Map(int x, int y){
        map = new int[x][y];
        for(int i= 0; i< map.length ; i++){
            for(int j = 0; j< map[j].length; j++){
                if(j != 4 && i> 4){
                    map[i][j]= 0;
                }
                else{
                    map[i][j]= 1;
                }
            }
        }
    }

    public int[][] getMap(){
        return map;
    }
}
