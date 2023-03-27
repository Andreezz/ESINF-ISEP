/*package Exame2020R;

import java.util.LinkedList;

public class Ex4 {
    public LinkedList<String> pathSameLine(Graph<String,String> g, String stOrig, String stDest, String line){
        for (Edge<String,String> e:g){
            if (!e.getWeight.equals(line)){
                g.removeEdge(edge.getvOrig(), edge.getVDest());
            }
        }
        LinkedList<String> path=new LinkedList<>();
        Algorithms.shortestPath(g,stOrig,stDest,String::compareTo,String::concat,0,path);
        return path;
    }

}
*/