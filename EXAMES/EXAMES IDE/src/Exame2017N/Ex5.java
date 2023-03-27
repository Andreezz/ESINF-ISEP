/*package Exame2017N;

import java.util.Iterator;
import java.util.Map;

public class Ex5 {
    public static <K, V extends Comparable<V>> boolean isEquivalent(HeapPriorityQueue<K, V> heap1, HeapPriorityQueue<K, V> heap2) {

        if(heap1.size()!=heap2.size()){
            return false;
        }
        Iterator<Entry<K,V>> it1= heap1.iterator();
        Iterator<Entry<K,V>> it2= heap2.iterator();
        while(heap1.hasNext()&&heap2.hasNext()){
            Entry<K,V> e1= it1.next();
            Entry<K,V> e2= it2.next();
            if (!e1.getKey().equals(e2.getKey)){
                return false;
            }

        }
        return true;
    }

}
*/