package pl.edu.wat.wcy.isi.Operations;

import pl.edu.wat.wcy.isi.Model.SplayTreeNode;

import java.util.HashMap;

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

    public int minimumDepth()
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

    public String VerticalSumMain() { return VerticalSum(root); }

    // A wrapper over VerticalSumUtil()
    private String VerticalSum(SplayTreeNode root) {

        // base case
        if (root == null) { return ""; }

        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<>();

        // Calls the VerticalSumUtil() to store the
        // vertical sum values in hM
        VerticalSumUtil(root, 0, hM);

        // Prints the values stored by VerticalSumUtil()
        return  hM.entrySet().toString();
    }

    // Traverses the tree in Inoorder form and builds
    // a hashMap hM that contains the vertical sum
    private void VerticalSumUtil(SplayTreeNode root, int hD, HashMap<Integer, Integer> hM) {

        // base case
        if (root == null) {  return; }

        // Store the values in hM for left subtree
        VerticalSumUtil(root.getLeft(), hD - 1, hM);

        // Update vertical sum for hD of this node
        int prevSum = (hM.get(hD) == null) ? 0 : hM.get(hD);
        hM.put(hD, prevSum + root.getValue());

        // Store the values in hM for right subtree
        VerticalSumUtil(root.getRight(), hD + 1, hM);
    }
}
