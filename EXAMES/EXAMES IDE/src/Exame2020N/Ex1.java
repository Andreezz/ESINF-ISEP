/*import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Ex1 {

    public static<K, E extends Comparable<E>> List<Pair<K,E>> mergeLists(List<Pair<K,E>> A, List<Pair<K,E>> B){
        List<Pair<K,E>> result = new LinkedList<>();
        result.addAll(A);
        result.addAll(B);
        result.sort(Comparator.comparing(Pair::getValue));
        return result;
    }
}*/
