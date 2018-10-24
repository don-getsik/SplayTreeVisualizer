package pl.edu.wat.wcy.isi.Model;

public class SplayTreeNode {

    private SplayTreeNode father;
    private SplayTreeNode left;
    private SplayTreeNode right;
    private Integer value;
    static private SplayTreeNode root;

    static public SplayTreeNode getRoot() {return root;}
    static public boolean isRoot() {return root != null;}
    static public void setRoot (SplayTreeNode node) {root = node;}


    public SplayTreeNode (Integer key) {
        value = key;
    }

    public SplayTreeNode getFather() {return father;}
    public void setFather(SplayTreeNode father) {this.father = father;}
    public SplayTreeNode getLeft() {return left;}
    public void setLeft(SplayTreeNode left) {this.left = left;}
    public SplayTreeNode getRight() {return right;}
    public void setRight(SplayTreeNode right) {this.right = right;}
    public Integer getValue() {return value;}
    public void setValue(Integer value) { this.value = value;}

    @Override
    public String toString() {
        return value.toString();
    }

    public static void deleteAll() {
        root = null;
    }

    public static void paintTree() {
        if (root != null) root.paint();
        System.out.println();
    }

    private void paint () {
        System.out.print(value);
        if(left != null) {
            System.out.print(" l-> ");
            left.paint();
        }
        if (right != null) {
            System.out.print(" r-> ");
            right.paint();
        }
    }
}

