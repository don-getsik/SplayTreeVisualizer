package Model;

public class SplayTreeNode {

    private SplayTreeNode father;
    private SplayTreeNode left;
    private SplayTreeNode right;
    private Integer value;

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
}
