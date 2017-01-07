package Model;

/**
 * Created by 204g14 on 09.12.2016.
 */
public class Map {
    private int[][] map;
    private Stack<int[]> waypoints;
    private int[] spawn;
    private int[] finish;
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
        spawn = new int[2];
        spawn[0] = 19;
        spawn[1] = 5;
        finish = new int[2];
        finish[0] = 0;
        finish[1] = 5;


        waypoints = new Stack<>();

        int[] m = new int[2];
        m[0] = 6;
        m[1] = 5;
        waypoints.push(m);
        int[] n = new int[2];
        n[0] = 6;
        n[1] = 8;
        waypoints.push(n);
        int[] o = new int[2];
        o[0] = 14;
        o[1] = 8;
        waypoints.push(o);
        int[] p = new int[2];
        p[0] = 14;
        p[1] = 5;
        waypoints.push(p);
        waypoints.push(spawn);

        map = new int[x][y];



        for(int i = 0;i<spawn[0]-p[0];i++){
            map[spawn[0]-i-1][spawn[1]] = 1;
        }
        for(int i =0;i<o[1]-p[1];i++ ){
            map[p[0]][p[1]+i] = 1;
        }
        for(int i = 0;i<o[0]-n[0];i++){
            map[o[0]-i][n[1]] = 1;
        }
        for(int i =0;i<n[1]-m[1]+1;i++ ){
            map[m[0]][m[1]+i] = 1;
        }
        for(int i = 0;i<m[0]-finish[0];i++){
            map[m[0]-i-1][m[1]] = 1;
        }




    }

    public Stack<int[]> getWaypoints(){
        return waypoints;
    }

    public int[][] getMap(){
        return map;
    }
}
