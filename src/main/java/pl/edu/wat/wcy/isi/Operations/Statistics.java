package pl.edu.wat.wcy.isi.Operations;

import pl.edu.wat.wcy.isi.Model.SplayTree;
import pl.edu.wat.wcy.isi.Model.SplayTreeNode;

public class Statistics {

    private SplayTreeNode root;

    public Statistics (SplayTreeNode root) {
        this.root = root;
    }

    public int countNodes() {
        if (root != null) return recursiveCountNodes(root);
        else return 0;
    }

    private int recursiveCountNodes(SplayTreeNode node) {
        int number = 0;
        if (node.getLeft() != null) number += recursiveCountNodes(node.getLeft());
        if (node.getRight() != null) number += recursiveCountNodes(node.getRight());
        return number +1;
    }

    public int treeDepth() {
        if (root!= null) return maxDepth(root);
        else return 0;
    }

    private int maxDepth(SplayTreeNode node)
    {
        if (node == null) return 0;
        int lDepth = maxDepth(node.getLeft());
        int rDepth = maxDepth(node.getRight());
        if (lDepth > rDepth) return (lDepth + 1);
        else return (rDepth + 1);
    }
}
