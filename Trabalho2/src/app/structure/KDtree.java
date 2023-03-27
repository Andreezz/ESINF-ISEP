package app.structure;

import java.awt.geom.Point2D;
import java.util.Comparator;

public class KDtree <E extends Comparable<E>> extends BST<E>
{

    /* Nested static class for a KD tree node. */
    public static class KDNode<E> extends BST.Node<E> {

        protected Point2D.Double coords;

        public KDNode(E e, KDNode<E> leftChild, KDNode<E> rightChild, double x, double y) {
            super(e, leftChild, rightChild);
            this.coords = new Point2D.Double(x, y);
        }

        public double getX(){ return this.coords.getX(); }

        public double getY(){ return this.coords.getY(); }

        public void setObject(KDNode<E> node){
            this.setElement(node.getElement());
            this.setLeft(node.getLeft());
            this.setRight(node.getRight());
            this.coords = new Point2D.Double(node.getX(), node.getY());
        }
    }

    //----------- end of nested Node class -----------

    public E getElement(KDNode<E> node, double x, double y){
        if (node == null){
            return null;
        }
        // node has same coordinates as instance
        if((Double.compare(node.getX(), x) == 0) && (Double.compare(node.getY(), y) == 0))
            return node.getElement();
        // node has even height (x is compared)
        if(height(node) % 2 == 0) {
            if (Double.compare(node.getX(), x) > 0)
                return getElement((KDNode<E>) node.getLeft(), x, y);
            else
                return getElement((KDNode<E>) node.getRight(), x, y);
        }
        // node has odd height (y is compared)
        else{
            if (Double.compare(node.getY(), y) > 0)
                return getElement((KDNode<E>) node.getLeft(), x, y);
            else
                return getElement((KDNode<E>) node.getRight(), x, y);
        }
    }

    /**
     *
     * @param element
     * @param x
     * @param y
     */
    public void insert(E element, double x, double y) {
        root = insert((KDNode<E>) root, new KDNode<>(element, null, null, x, y), true);
    }

    /**
     *
     * @param currentNode
     * @param node
     * @param divX
     * @return KDNode<E>
     */
    private KDNode<E> insert(KDNode<E> currentNode, KDNode<E> node, boolean divX) {
        if(currentNode == null)
            return new KDNode<>(node.getElement(), null, null, node.getX(), node.getY());

        if (node.coords.equals(currentNode.coords))
            return currentNode;

        int cmpResult = (divX ? cmpX : cmpY).compare(node, currentNode);

        if (cmpResult < 0) {
            if (currentNode.getLeft() == null)
                currentNode.setLeft(insert((KDNode<E>) currentNode.getLeft(), node, !divX));
            else
                insert((KDNode<E>) currentNode.getLeft(), node, !divX);
        }

        else if (currentNode.getRight() == null)
            currentNode.setRight(insert((KDNode<E>) currentNode.getRight(), node, !divX));
        else
            insert((KDNode<E>) currentNode.getRight(), node, !divX);

        return currentNode;
    }

    /**
     * Finds the nearest node with the values introduced
     *
     * @param node
     * @param x
     * @param y
     * @param closestNode
     * @param divX
     * @return object
     */
    public E findNearestNeighbour(KDNode<E> node, double x, double y, KDNode<E> closestNode, boolean divX) {
        if (node == null)
            return null;

        double d = Point2D.distanceSq(node.coords.getX(), node.coords.getY(), x, y);
        double closestDist;

        if (closestNode != null) {
            closestDist = Point2D.distanceSq(closestNode.coords.getX(), closestNode.coords.getY(), x, y);
            if (closestDist > d)
                closestNode.setObject(node);
        }

        else {
            closestDist = Double.POSITIVE_INFINITY;
            if (closestDist > d) {
                closestNode = new KDNode<>(node.getElement(), null, null, node.getX(), node.getY());
                closestDist = d;
            }
        }

        double delta = divX ? x - node.coords.getX() : y - node.coords.getY();
        double delta2 = delta * delta;

        KDNode<E> node1 = delta < 0 ? (KDNode<E>) node.getLeft() : (KDNode<E>) node.getRight();
        KDNode<E> node2 = delta < 0 ? (KDNode<E>) node.getRight() : (KDNode<E>) node.getLeft();

        findNearestNeighbour(node1, x, y, closestNode, !divX);

        if (delta2 < closestDist)
            findNearestNeighbour(node2, x, y, closestNode, !divX);
        return closestNode.getElement();
    }

    private final Comparator<KDNode<E>> cmpX = new Comparator<KDNode<E>>(){
        @Override
        public int compare(KDNode<E> p1, KDNode<E> p2) { return Double.compare(p1.getX(), p2.getX()); }
    };

    private final Comparator<KDNode<E>> cmpY = new Comparator<KDNode<E>>(){
        @Override
        public int compare(KDNode<E> p1, KDNode<E> p2) { return Double.compare(p1.getY(), p2.getY()); }
    };
    public void remove(E element) {

        root = remove(element, root());
    }

    private Node<E> remove(E element, Node<E> node) {
        System.out.println(element);
        System.out.println(node.getElement());
        if (node == null) {
            return null;    //throw new IllegalArgumentException("Element does not exist");
        }
        if (element.equals(node.getElement())) {
            // node is the Node to be removed
            if (node.getLeft() == null && node.getRight() == null) { //node is a leaf (has no childs)
                return null;
            }
            if (node.getLeft() == null) {   //has only right child
                return node.getRight();
            }
            if (node.getRight() == null) {  //has only left child
                return node.getLeft();
            }
            E min = smallestElement(node.getRight());
            node.setElement(min);
            System.out.println("mid");
            node.setRight(remove(min, node.getRight()));
        } else if (element.compareTo(node.getElement()) < 0){
            System.out.println("left");
            node.setLeft(remove(element, node.getLeft()));
        }

        else{
            System.out.println("right");
            node.setRight(remove(element, node.getRight()));}

        return node;
    }
    public E smallestElement() {
        return smallestElement(root());
    }

    protected E smallestElement(Node<E> node) {
        if (node.getLeft() == null) {
            return node.getElement();
        }
        return smallestElement(node.getLeft());
    }
}


