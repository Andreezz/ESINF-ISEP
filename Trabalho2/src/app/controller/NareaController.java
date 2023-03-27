package app.controller;

import app.model.Data;
import app.structure.BST;

import java.util.HashMap;
import java.util.Map;

import java.util.List;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;

public class NareaController {

    BST<Data> bstTree = new BST();


    public NareaController() {


    }

    /**
     * @param item     is the item that we need from the csv
     * @param element  is the element that we need from the csv
     * @param mainTree is the Bst where we save all the information
     * @return the entire tree
     */
    public BST<Data> element_itensubtree(String item, String element, BST<Data> mainTree) {

        for (Data a1 : mainTree.inOrder()) {
            if (a1.getItem().getItem().equals(item)) {
                if (a1.getElement().getElement().equals(element)) {
                    bstTree.insert(a1);
                }
            }
        }

        return bstTree;
    }

    /**
     * @param bstTree receives as a parameter, because it is the tree that contains the necessary information
     * @return the map filled in with the last year of registration and its respective values
     */
    public Map<String, Double> year_narea(BST<Data> bstTree) {
        BST<Data> yearTree = new BST<>();
        int last_year = 0;
        for (Data a1 : bstTree.inOrder()) {
            if (a1.getYear().getYear().compareTo(last_year) > 0)
                last_year = a1.getYear().getYear();

        }
        for (Data a1 : bstTree.inOrder()) {
            if (a1.getYear().getYear() == last_year) {
                yearTree.insert(a1);
            }
        }
        Map<String, Double> nArea = new HashMap<>();
        for (Data a2 : yearTree.inOrder()) {
            nArea.put(a2.getArea().getArea(), a2.getValue().getValue());
        }

        return nArea;
    }

    /**
     * @param mapArea receives as a parameter, because it is the map that contains the last year of registration and the values that we intend to organize in descending order
     * @param n       number of TopNareas
     * @return the number of areas with the highest value in the last year of registration for a given element and item
     */
    public Map<String, Double> Narea(Map<String, Double> mapArea, int n) {
        List<Map.Entry<String, Double>> list =
                new LinkedList<Map.Entry<String, Double>>(mapArea.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
            public int compare(Map.Entry<String, Double> o1,
                               Map.Entry<String, Double> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Double> temp = new LinkedHashMap<String, Double>();
        for (Map.Entry<String, Double> aa : list) {
            if (temp.size() == n)
                return temp;
            temp.put(aa.getKey(), aa.getValue());
            
        }

        return temp;
    }
}
