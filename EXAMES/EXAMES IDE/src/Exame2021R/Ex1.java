package Exame2021R;

import Exame2022E.E;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Ex1 {

    public static void main(String[] args) {
        List<Integer> l = new LinkedList<>();
        l.add(4);
        l.add(5);
        l.add(8);
        l.add(9);

        List<Integer> p = new LinkedList<>();
        p.add(8);
        p.add(9);
        p.add(9);
        p.add(3);
        p.add(9);
        p.add(5);
        p.add(8);
        p.add(8);
        p.add(3);

        favouriteList(l, p);
    }
    public static void favouriteList(List<Integer> l,List<Integer> p){
       List<Integer> finalList=new LinkedList<>();
       for (Integer i:p){
           if (l.contains(i)){
               if (!finalList.contains(i)){
                   finalList.add(i);
               };
           }
           }
       for (Integer i:l){
           if (!finalList.contains(i)) finalList.add(i);
       }
        System.out.println(finalList);
       }

}
