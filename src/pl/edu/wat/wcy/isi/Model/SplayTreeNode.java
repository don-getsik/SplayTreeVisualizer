package pl.edu.wat.wcy.isi.Model;

import java.awt.*;

public class SplayTreeNode {

    private SplayTreeNode father;
    private SplayTreeNode left;
    private SplayTreeNode right;
    private Integer value;
    static private SplayTreeNode root;
    private Color color;

    static public SplayTreeNode getRoot() {return root;}
    static public boolean isRoot() {return root != null;}
    static public void setRoot (SplayTreeNode node) {root = node;}


    public SplayTreeNode (Integer key) {
        value = key;
        color = Color.BLACK;
    }

    public SplayTreeNode getFather() {return father;}
    public void setFather(SplayTreeNode father) {this.father = father;}
    public SplayTreeNode getLeft() {return left;}
    public void setLeft(SplayTreeNode left) {this.left = left;}
    public SplayTreeNode getRight() {return right;}
    public void setRight(SplayTreeNode right) {this.right = right;}
    public Integer getValue() {return value;}
    public void setColor(Color color) { this.color = color; }
    public Color getColor() {return color;}

    @Override
    public String toString() {
        return value.toString();
    }

    public static void deleteAll() { root = null; }
    public static void setAllColorsBlack () { root.setColorBlack(); }

    private void setColorBlack () {
        color = Color.BLACK;
        if(left != null) left.setColorBlack();
        if(right != null) right.setColorBlack();
    }
}

