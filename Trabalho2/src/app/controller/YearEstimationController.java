package app.controller;

import app.model.*;
import app.structure.BST;

import java.util.*;

public class YearEstimationController {

    public LinkedHashMap<Data, Double> yearEstimationController (BST<Data> bstt, String area, int year1, int year2) {
        LinkedHashMap<Data, Double> results = new LinkedHashMap<>();
        Set<Data> dataRestricted = dataRestricted(bstt,area, year1, year2);
        Set<String> eachItemSet = itemSet(dataRestricted);
        ArrayList<Data> dataRestrictedArr = new ArrayList<>(dataRestricted);
        dataRestrictedArr.sort(new SortByYear());
        for (String item : eachItemSet){
            int counter = 0;
            double soma = 0, media = 0;
            Set<Data> data = new HashSet<>();
            for (Data dataIt : dataRestrictedArr) {
                if (dataIt.getItem().getItem().equals(item)) {
                    counter++;
                    soma = soma + dataIt.getValue().getValue();
                    if (data.isEmpty())
                        data.add(dataIt);
                }
            }
            media = soma / counter;
            results.put(data.iterator().next(), media);
            media = 0;
            soma = 0;
        }
        return results;
    }
    public Set<Data> dataRestricted(BST<Data> bst,String area, int year1, int year2) {
        Set<Data> dataRestricted = new HashSet<>();
        for (Data d : bst.preOrder()) {
            if (d.getArea().getArea().equals(area) && d.getYear().getYear() >= year1 && d.getYear().getYear() <= year2) {
                dataRestricted.add(d);
            }
        }
        return dataRestricted;
    }
    private Set<String> itemSet(Set<Data> dataRestricted) {
        Set<String> itemSet = new HashSet<>();
        for (Data data : dataRestricted) {
            itemSet.add(data.getItem().getItem());
            }
        return itemSet;
    }

}

class SortByYear implements Comparator<Data> {
    public int compare(Data a, Data b) {
        int year = a.getYear().getYear().compareTo(b.getYear().getYear());
        int item = a.getItem().getItem().compareTo(b.getItem().getItem());
        return (item == 0) ? year : item;
    }
}
