/*package Exame2020N;

import java.util.LinkedList;

public class Ex4 {
    public List<NoPetri> nosTransicao() {
        List<NoPetri> finalList = new LinkedList<>();
        for (NoPetri n : g.vertices) {
            if (n.isTransicao()) {
                if (g.incomingEdges == numArestas(g.incomingEdges(n) && numArestas(g.incomingEdges(n))!=0)){
                    finalList.add(n);
                }
            }
        }
        return finalList;
    }

    public int numArestas(Coolections<Edge<NoPetri, Integer>> list) {
        int i = 0;
        for (Edge<NoPetri, Integer> e : list) {
            if (e.getorig().temToken()) {
                i++;
            }
        }
        return i;
    }
}*/
