/*package Exame2020R;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Ex1 {
    public static void main(String[] args) {

    }

    public static String commonFirstName(List<String> names, List<String> nicknames) {
        Map<String, List<String>> mapa = new HashMap<>();
        for (int i = 0; i < names.size(); i++) {
            if (!mapa.containsKey(names.get(i))) {
                List<String> ap = new LinkedList<>();
                ap.add(nicknames.get(i));
                mapa.put(names.get(i), ap);
            } else if (!mapa.get(names.get(i)).contains(nicknames.get(i))){
                mapa.get(names.get(i)).add(nicknames.get(i));
            }
        }
        List<Map<String, List<String>>> lista=new LinkedList<>();
        lista.sort((o1, o2) -> o2.getValue().size()-o1.getValue().size());
        return lista.get(0).getKey;
    }
}
*/