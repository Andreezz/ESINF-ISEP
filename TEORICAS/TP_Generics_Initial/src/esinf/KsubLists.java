package esinf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class KsubLists {
    public static Map<Integer, LinkedList<Integer>> kSubLists(LinkedList<Integer> list, ArrayList<Integer> centers){
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (Integer c : centers){
            map.put(c, new LinkedList<>());
        }

        for (Integer n : list){
            Integer distance = null, closestCenter = null;
            for (Integer c : map.keySet()){
                if (distance == null || Math.abs(c - n) < distance){
                    distance =  Math.abs(c - n);
                    closestCenter = c;
                }
            }
            map.get(closestCenter).add(n);
        }

        return map;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList();
        ArrayList<Integer> centers = new ArrayList<>();

        list.add(2);
        list.add(9);
        list.add(7);
        list.add(5);
        list.add(10);
        list.add(15);
        list.add(6);
        list.add(12);
        list.add(3);

        centers.add(3);
        centers.add(6);
        centers.add(10);

        Map<Integer, LinkedList<Integer>> map = kSubLists(list, centers);

        System.out.println(map);
    }
}
