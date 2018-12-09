package pl.edu.wat.wcy.isi.Operations;

import pl.edu.wat.wcy.isi.Model.SplayTreeNode;

public class TreeOrder {

    private int[] preOrder;
    private int[] inOrder;
    private int[] postOrder;
    private int preOrderCounter = 0;
    private int inOrderCounter = 0;
    private int postOrderCounter = 0;
    private int nodes;
    private SplayTreeNode root;

    public TreeOrder(SplayTreeNode root) {
        nodes = new Statistics(root).countNodes();
        this.root = root;
    }

    private void recursivePreOrder (SplayTreeNode node) {
        preOrder[preOrderCounter++] = node.getValue();
        if (node.getLeft() !=  null) recursivePreOrder(node.getLeft());
        if (node.getRight() != null) recursivePreOrder(node.getRight());
    }

    private void recursiveInOrder (SplayTreeNode node) {
        if (node.getLeft() != null) recursiveInOrder(node.getLeft());
        inOrder[inOrderCounter++] = node.getValue();
        if (node.getRight() != null) recursiveInOrder(node.getRight());
    }

    private void recursivePostOrder (SplayTreeNode node) {
        if (node.getLeft() != null) recursivePostOrder(node.getLeft());
        if (node.getRight() != null) recursivePostOrder(node.getRight());
        postOrder[postOrderCounter++] = node.getValue();
    }

    public int[] getPreOrder() {
        if (preOrder == null) {
            preOrder = new int[nodes];
            if (root != null) recursivePreOrder(root);
        }
        return preOrder;
    }

    public int[] getInOrder() {
        if(inOrder == null) {
            inOrder = new int[nodes];
            if (root != null) recursiveInOrder(root);
        }
        return inOrder;
    }

    public int[] getPostOrder() {
        if (postOrder == null)  {
            postOrder = new int[nodes];
            if (root != null) recursivePostOrder(root);
        }
        return postOrder;
    }
}
