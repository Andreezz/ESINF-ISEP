/*package Exame2022E;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ex5 {
    public static void main(String[] args) {

    }
    public Integer graphDiameter(Graph<User,Integer> g){
        ArrayList<LinkedList<User>> paths =new ArrayList<>();
        ArrayList<Integer> dists=new ArrayList<>();
        ArrayList<LinkedList<User>> allpaths=new ArrayList<>();
        for (User u: g.vertices){
            Algorithms.shortestPaths(g,u,Integer::compareTo,Integer::sum,0,paths,dists);
            allpaths.addAll(paths);
        }
        LinkedList<User> bigPath=new LinkedList<>();
        for (LinkedList<User> u:allPaths){
            if(u!=null){
                if (bigPath.isEmpty()) bigPath=u;
                if (bigPath.size()<u.size()) bigPath=u;
            }
        }
        return bigPath.size();
    }
}
*/
