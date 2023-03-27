package Exame2022E;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Ex1 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1930, "Uruguay");
        map.put(1934, "Italy");
        map.put(1938, "Italy");
        map.put(1950, "Uruguay");
        map.put(2006, "Italy");
        map.put(2010, "Spain");
        List<Map.Entry<Integer, String>> lf = new LinkedList<>(map.entrySet());
        System.out.println(footWorldCup(lf));
    }

    public static Map<String, List<Integer>> footWorldCup(List<Map.Entry<Integer, String>> lf) {
        Map<String, List<Integer>> lista = new HashMap<>();
        for (Map.Entry<Integer, String> entry : lf) {
            if (!lista.containsKey(entry.getValue())) {
                List<Integer> year = new LinkedList<>();
                year.add(entry.getKey());
                lista.put(entry.getValue(), year);

            } else {
                lista.get(entry.getValue()).add(entry.getKey());
                lista.get(entry.getValue()).sort((o1, o2) -> o2 - o1);
            }
        }
        return lista;
    }
}
