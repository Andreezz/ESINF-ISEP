/*package Exame2021R;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ex4 {
    public static void main(String[] args) {

    }
    public Ponto faramciaMaisProxima(Ponto pIni, List<Ponto> pointsVisited){
        ArrayList<linkedList<Ponto>> paths=new ArrayList<>();
        ArrayList<Double> dist=new ArrayList<>();
        Graph<Ponto, Double> g = new Graph<>(true);
        List<Ponto> listFinal = new LinkedList<>();
        double minDistance = Double.MAX_VALUE;
        ArrayList<linkedList<Ponto>> pathswithNopoints=new ArrayList<>();
        Algorithms.shortestPaths(g, pIni, Double::compareTo, Double::sum, 0, paths,dist);
        for (linkedList<Ponto> li:paths){
            if (!pointsVisited.contains(li.getLast())&&li.getLats().isFarmacia()){
                pathswithNopoints.add(li);
            }
        }

        for (List<Ponto> p : pathWithNoVisitedPoints) {
            if (getDistance(p) < minDistance) {
                minDistance = getDistance(p);
                listFinal = p;
            }
        }


        return listFinal.get(listFinal.size() - 1);
    }
}*/
