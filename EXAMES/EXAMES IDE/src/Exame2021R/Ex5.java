/*package Exame2021R;

import java.util.LinkedList;
import java.util.List;

public class Ex5 {
    public static <K, V> List<V> colourPriority(HeapPriorityQueue<K, V> hp, int numElems, int priority) {
        List<V> red = new LinkedList<>();
        List<V> yellow = new LinkedList<>();
        List<V> green = new LinkedList<>();

        while (!hp.isEmpty()) {
            if (red.size() < numElems) {
                red.add(hp.min().getValue());
                hp.removeMin();
            } else if (yellow.size() < hp.size() - numElems) {
                yellow.add(hp.min().getValue());
                hp.removeMin();
            } else {
                green.add(hp.min().getValue());
                hp.removeMin();
            }
        }

        switch (priority) {
            case (1):
                return red;
            case(2):
                return yellow;
            case(3):
                return green;
            default:
                return null;
        }
    }

}
*/