/*package Exame2021N;

public class Ex3 {
    
public boolean isSymmetric(){
    return isMirror(root, root);
}

private boolean isMirror(Node left, Node right) {
    if (left == null && right == null) return true;
    if (left == null || right == null) return false;
    return (left.val == -right.val)
     && isMirror(left.left, right.right)
     && isMirror(left.right, right.left);
}

    
}*/
