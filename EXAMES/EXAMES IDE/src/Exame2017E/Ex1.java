package Exame2017E;

import java.util.*;

public class Ex1 {
    public static void main(String[] args) {
        LinkedList<Integer> lst = new LinkedList<>();
        lst.add(2);
        lst.add(9);
        lst.add(5);
        lst.add(10);
        lst.add(15);
        lst.add(6);
        lst.add(12);
        lst.add(3);
        lst.add(11);
        lst.add(8);
        System.out.println(multiReverse(lst,3));
    }

    public static Map<Integer, LinkedList<Integer>> multiReverse(LinkedList<Integer> list, Integer n) {
        Map<Integer, LinkedList<Integer>> mapa = new HashMap<>();
        int i = 0;
        int x = 1;
        while (i < list.size()) {
            int y = 0;
            LinkedList<Integer> newList = new LinkedList<>();
            if (i + (2 * n) - 2 >= list.size()) {
                while (i <list.size()) {
                    int a = list.get(i);
                    newList.add(a);
                    i++;
                }
            } else {
                while (y < n) {
                    int a = list.get(i);
                    newList.add(a);
                    i++;
                    y++;
                }
            }
            Collections.reverse(newList);
            mapa.put(x,new LinkedList<>(newList));
            x++;
        }
        return mapa;
    }
}
