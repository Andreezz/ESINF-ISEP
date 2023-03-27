/*package Exame2019N;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class Ex5 {
    public static void main(String[] args) {

    }

    public List<E> getElemsPaths(int idx) {
        Node root;
        List<E> lista = new ArrayList<>();
        Node current=findNode(root,idx);
        while (idx!=0){
            lista.add(current.value);
            idx=parent(idx);
            current=findNode(root,idx);
        }
        return lista;
    }
}*/
