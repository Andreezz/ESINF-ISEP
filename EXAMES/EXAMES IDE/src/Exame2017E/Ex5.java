package Exame2017E;

import java.util.Map;

public class Ex5 {
    public static HeapPriorityQueue<K,V>  subHeap(HeapPriorityQueue<K, V> heap) {
        HeapPriorityQueue<K,V> subheap=new HeapPriorityQueue<>();

        for (Entry<K,V>e:heap){
            if (!subheap.contains(e.getValue())){
                subheap.add(e.getKey(),e.getValue());
            }
        }
        return subheap;
    }
}
