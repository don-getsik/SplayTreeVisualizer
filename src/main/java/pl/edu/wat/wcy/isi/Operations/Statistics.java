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

    public int getLeafCount()
    {
        return getLeafCount(root);
    }

    private int getLeafCount(SplayTreeNode node)
    {
        if (node == null)
            return 0;
        if (node.getLeft() == null && node.getRight() == null)
            return 1;
        else
            return getLeafCount(node.getLeft()) + getLeafCount(node.getRight());
    }

    int minimumDepth()
    {
        return minimumDepth(root);
    }

    /* Function to calculate the minimum depth of the tree */
    private int minimumDepth(SplayTreeNode root)
    {
        // Corner case. Should never be hit unless the code is
        // called on root = NULL
        if (root == null)
            return 0;

        // Base case : Leaf Node. This accounts for height = 1.
        if (root.getLeft() == null && root.getRight() == null)
            return 1;

        // If left subtree is NULL, recur for right subtree
        if (root.getLeft() == null)
            return minimumDepth(root.getRight()) + 1;

        // If right subtree is NULL, recur for left subtree
        if (root.getRight() == null)
            return minimumDepth(root.getLeft()) + 1;

        return Math.min(minimumDepth(root.getLeft()),
                minimumDepth(root.getRight())) + 1;
    }
}
