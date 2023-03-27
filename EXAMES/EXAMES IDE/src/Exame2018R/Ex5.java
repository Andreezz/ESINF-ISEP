/*package Exame2018R;

public class Ex5 {
    public	<K,V	extends	Comparable<V>>	HeapPriorityQueue<K,V>  remValues(HeapPriorityQueue<K,V>	heap,	V	value){
        int i;
        for (Entry<K,V> e: heap){
               if (e.getValue().equals(value)){
                   while(e.getKey!=0){
                       percolateUp(e.getKey);
                   }
            }
               heap.removeMin();
        }
        return heap;
    }

}*/
