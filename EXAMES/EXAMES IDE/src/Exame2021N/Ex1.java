/*package Exame2021N;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Ex1 {

    public static void main(String[] args) {

    }

    public Map<Integer, ArrayList<Pais>> numBorders(list<Pair<Pais, Pais>> lf) {
        TreeMap<Integer, ArrayList<Pais>> borders = new TreeMap<>();
        List<Pais> pais = new ArrayList<>();
        for (Pair<Pais, Pais> p : lf) {
            pais.add(p.getKey());
            pais.add(p.getValue());
        int num;
        for (Pais pais1 : pais) {
            num = number(pais, pais1);
            if (!borders.containsKey(num)){
                ArrayList<Pais> paisArrayList=new ArrayList<>();
                paisArrayList.add(pais1);
                borders.put(num,paisArrayList);
            }
            else if (!borders.get(num).contains(pais1)){
                borders.get(num).add(pais1);
            }
            }
        }
        return borders;
    }

    public int number(List<Pais> pais, Pais p) {
        int i = 0;
        for (Pais pais1 : pais) {
            if (pais1.equals(p)) i++;
        }
        return i;
    }

}*/