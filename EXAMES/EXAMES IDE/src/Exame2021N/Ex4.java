/*package Exame2021N;

import java.util.LinkedList;

public class Ex4 {
    private Graph<String,Double> g = new Graph<>(true);
    public LinkedList<String> alternativePath(String stOrig, String stDest, String stManut){
        g.removeVertex(stManut);
        LinkedList<String> path=new LinkedList<>();
        Algorithms.shortestPath(g,stOrig,stDest,Double::compareTo,Double::sum,0,path);
        return path;
    }
}*/
