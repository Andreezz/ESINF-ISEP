/*package Exame2020N;

public class Ex5{
        public HeapPriorityQueue<Integer,String>  mergeHeaps(HeapPriorityQueue<Integer,String> hp1, HeapPriorityQueue<Integer,String> hp2) {
            int size=hp1.size()+hp2.size();
            Integer []keys=new Integer[size];
            String[] values=new String[size];
            int i=0;
            while(!hp1.isEmpty){
                keys[i]=hp1.min().getKeys();
                values[i]=hp1.min().getValues();
                i++;
                hp1.removeMin();
            }
            while(!hp2.isEmpty){
                keys[i]=hp2.min().getKeys();
                values[i]=hp2.min().getValues();
                i++;
                hp2.removeMin();
            }
            return new HeapPriorityQueue<>(keys,values);
        }
}*/
