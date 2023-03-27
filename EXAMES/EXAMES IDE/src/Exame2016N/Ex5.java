package Exame2016N;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

public class Ex5 {
    public static List<V>  SmallestNInHeap(HeapPriorityQueue<K,V> heap, int n){
       int i=0;
        List<V> lista=new LinkedList<>();
        for (Entry<K,V> e:heap){
            while(i<n){
                lista.add(e.getValue());
                i++;
            }
        }
        lista.sort((o1,o2) -> o2-o1);
        for (Entry<K,V> e:heap){
            if (e.getValue()<lista.get(0)){
                lista.get(0)=e.getValue();
                lista.sort((o1,o2)->o2-o1);
            }
        }
        return lista;
    }
    public static List<V>  SmallestNInHeap(HeapPriorityQueue<K,V> heap, int n){
        int i=0;
        List<V> lista=new LinkedList<>();
        List<V> listaFinal=new LinkedList<>();
        for (Entry<K,V> e:heap){
                lista.add(e.getValue());
        }
        lista.sort((o1,o2) -> o1.compareTo(o2));
        while(i<n){
            listaFinal.add(lista.get(i));
            i++;
        }
        return listaFinal;
    }
}
