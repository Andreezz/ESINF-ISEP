/*package Exame2022E;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex3 {
    public static void main(String[] args) {

    }

    public List<List<E>> allpaths(){
        List<List<E>> allpaths=new LinkedList<>();
        List<E> nodes=new LinkedList<>();
        List<E> allNodes=(List<E>) inOrder();

        for (E element : allElements) {
            Node<E> node = root;
            while (node.getElement().compareTo(element) != 0) {
                if (element.compareTo(node.getElement()) < 0) {
                    node = node.getLeft();
                }
                if (element.compareTo(node.getElement()) > 0) {
                    node = node.getRight();
                }
            }
            if (node.getLeft() == null && node.getRight() == null) {
                terminalNodes.add(node.getElement());
            }
        }
        for (E element : terminalNodes) {
            Node<E> node = root;
            List<E> path = new LinkedList<>();

            while (node.getElement().compareTo(element) != 0) {
                if (element.compareTo(node.getElement()) < 0) {
                    path.add(node.getElement());
                    node = node.getLeft();
                }
                if (element.compareTo(node.getElement()) > 0) {
                    path.add(node.getElement());
                    node = node.getRight();
                }
            }
            path.add(node.getElement());
            allPaths.add(path);
        }
        return allPaths;
    }
    }

}*/
