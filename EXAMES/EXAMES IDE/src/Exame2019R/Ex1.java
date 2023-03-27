package Exame2019R;

import java.util.*;

public class Ex1 {
    public static void main(String[] args) {
        Double capc = 10.0;
        Map<Integer, LinkedList<Double>> paletes=new HashMap<>();
        Double i1= 4.0;
        Double i2=8.0;
        Double i3=2.0;
        Double i4=1.0;
        Double i5=7.0;
        Double i6=6.0;
        Double i7=1.0;
        Double i8=4.0;
        Double i9=5.0;
        Double i0=2.0;
        List<Double> pesos=new LinkedList<>();
        pesos.add(i1);
        pesos.add(i2);
        pesos.add(i3);
        pesos.add(i4);
        pesos.add(i5);
        pesos.add(i6);
        pesos.add(i7);
        pesos.add(i8);
        pesos.add(i9);
        pesos.add(i0);
        packing(capc,pesos,paletes);
        System.out.println(paletes);
    }

    public static int packing(Double capac, List<Double> pesos, Map<Integer, LinkedList<Double>> paletes) {
        int palNum = 1;
        double count = 0;
        while (!pesos.isEmpty()) {
            LinkedList<Double> pesoPalete = new LinkedList<>();
            Iterator<Double> iterator = pesos.iterator();
            while (iterator.hasNext()) {
                Double d = iterator.next();
                if (count + d <= capac) {
                    pesoPalete.add(d);
                    iterator.remove();
                    count += d;
                }
            }
            paletes.put(palNum,pesoPalete);
            palNum++;
            count = 0;
        }
        return palNum - 1;
    }
}
