/*package Exame2019R;

public class Ex5 {
    public	static<K,V extends	Comparable<V>>	int	NumbElemsLastLevel(HeapPriorityQueue<K,V>	heap){
        int nivel=0;
        int count=0;
        while(count+Math.pow(2,nivel)<heap.size()){
            count+=Math.pow(2,nivel);
            nivel++;
        }
        return heap.size()-count;
    }
}*/
