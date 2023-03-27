package Exame2017N;

import java.util.*;

public class Ex1 {
    public static void main(String[] args) {
        LinkedList<Integer> lst = new LinkedList<>();
        lst.add(2);
        lst.add(1);
        lst.add(3);
        lst.add(7);
        lst.add(8);
        lst.add(9);
        lst.add(4);
        lst.add(6);
        lst.add(7);
        System.out.println(roletaRussa(lst));

    }

    public static Map<Integer, LinkedList<Integer>> roletaRussa(LinkedList<Integer> list) {
        LinkedList<Integer> clone = new LinkedList<>(list);
        Random generator = new Random();
        int i = 0;
        Map<Integer, LinkedList<Integer>> mapa = new HashMap<>();
        while (list.size() != 1) {
            int ind = generator.nextInt(list.size());
            if (i + ind >= list.size()) {
                ind = i + ind - list.size();
            } else {
                ind = i + ind;
            }
            System.out.println(ind);
            i = ind;
            System.out.println(list);
            int o=list.remove(ind);
            int x=clone.indexOf(o);
            mapa.put(x, new LinkedList<>(list));
        }
        return mapa;
    }
}
