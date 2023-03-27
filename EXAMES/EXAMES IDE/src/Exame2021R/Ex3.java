/*package Exame2021R;

public class Ex3 {
    public int lengthInternalPath() {
    }

    private int lengthInternalPath(Node<E> node) {
        if (node == null) return 0;
        if (node.left==null&&node.right==null) return 0;
        return depth(node)+ lengthInternalPath(node.left)+lengthInternalPath(node.right);
    }
}*/