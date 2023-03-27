package app.controller;

import app.model.*;
import app.structure.BST;
import app.structure.KDtree;


public class FindAreaController {
    BST<Data> tree1=new BST<>();
    public DataCoordinates findNode(KDtree<DataCoordinates> KDtree, Double x, Double y) {
        KDtree<DataCoordinates> tree = KDtree;
        app.structure.KDtree.KDNode node = (app.structure.KDtree.KDNode) tree.root();
        app.structure.KDtree.KDNode nearNode = null;
        return tree.findNearestNeighbour(node, x, y, nearNode, true);
    }

    /**
     *
     * This functions receives a bst and sorts it by area,element , item and year
     * @param tree
     * @param dataCoordinates
     * @param element
     * @param item
     * @param year
     * @return Data
     */
    public Data findBST(BST<Data> tree, DataCoordinates dataCoordinates, String element, String item, int year) {
       tree1 = tree;
        String area=dataCoordinates.getArea().getArea();
        for (Data data : tree1.inOrder()) {
            if (data.getArea().getArea().compareTo(area)==0) {
                if (data.getElement().getElement().equals(element)){
                    if (data.getItem().getItem().equals(item)){
                        if (data.getYear().getYear().equals(year)){
                            return data;
                        }
                    }
                }
            }
        }
        return null;
    }
}
