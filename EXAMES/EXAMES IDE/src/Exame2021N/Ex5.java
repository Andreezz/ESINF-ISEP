/*package Exame2021N;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Ex5 {
    public List<Entry<K,V>> getCommonPathElements(int idx1, int idx2){
        List<Entry<K,V>> list1=new LinkedList<>();
        List<Entry<K,V>> list2=new LinkedList<>();
        list1.add(heap.get(idx1));
        list2.add(heap.get(idx2));

        while(idx1!=0){
            list1.add(heap.get(parent(idx1)));
            idx1=parent(idx1);
        }
        while(idx2!=0){
            list2.add(heap.get(parent(idx2)));
            idx2=parent(idx2);
        }
        list1.retainAll(list2);
        return list1;
    }
}*/
