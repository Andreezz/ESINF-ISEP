package Exame2018N;

import java.util.LinkedList;
import java.util.List;

public class Ex1 {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("carro");
        list.add("auto");
        list.add("auto");
        list.add("autocarro");
        list.add("carro");
        list.add("carro");
        list.add("autocarro");
        list.add("auto");
        List<String> finalL=new LinkedList<>();
       finalL= renomear(list);
        System.out.println(finalL);
    }

    public static List<String> renomear(List<String> lst) {
        List<String> finalList = new LinkedList<>();
        for (String s : lst) {
            if (!finalList.contains(s)) {
                finalList.add(s);
            }
            else{
                while(finalList.contains(s)){
                    s=s+'i';
                }
                finalList.add(s);
            }

        }

        return finalList;
    }

}
