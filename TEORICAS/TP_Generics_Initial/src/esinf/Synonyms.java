package esinf;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Synonyms {
    List<String> moreSynonyms(Map<String, List<String>> mapSyn, Integer i) {
        List<String> list = new LinkedList<>();
        Map<String, Integer> MapAux = new HashMap<>();
        for (List<String> l : mapSyn.values()) {
            for (String syn : l) {
                Integer cont = MapAux.get(syn);
                if (cont == null) {
                    MapAux.put(syn, 0);

                }
                cont++;
                MapAux.put(syn, cont);
                if (cont == i) {
                    list.add(syn);
                }
            }
        }
        return list;
    }

}
