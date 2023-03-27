/*package Exame2017N;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ex4 {
    public static double	smaller_connection	(No	no1,	No	no2,	LinkedList<String> lstNos){
        ArrayList<LinkedList<String>> paths=new ArrayList<>();
        ArrayList<Integer> dists=new ArrayList<>();
        LinkedList<String> smallList=new LinkedList<>();
        int size=20;
        int index=0;
        Algorithms.shortestPaths(g,no1,no2,Integer::compareTo,Integer::sum,0,paths,dists);
        for (LinkedList<String> l:paths){
            if (l.size()<size){
                smallList=l;
                size=l.size();
                index=paths.indexOf(l);
            }
        }
        lstNos=smallList;
        Double fluxo= dists.get(index)/(double) smallList.size();
        return fluxo;
    }

}*/
