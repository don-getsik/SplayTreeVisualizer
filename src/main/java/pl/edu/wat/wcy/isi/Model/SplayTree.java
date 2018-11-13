package pl.edu.wat.wcy.isi.Model;

public class SplayTree {

    private SplayTreeNode root;
    private String instruction;

    public SplayTree (String instruction) {
        if (SplayTreeNode.getRoot()!=null) copyNode(SplayTreeNode.getRoot(), null, false);
        this.instruction = instruction;
    }


    private void copyNode (SplayTreeNode node, SplayTreeNode father, boolean isRight) {
        SplayTreeNode newNode = new SplayTreeNode(node.getValue(), node.getColor());
        if(father != null) {
            if (isRight) father.setRight(newNode);
            else father.setLeft(newNode);
            newNode.setFather(father);
        }
        else root = newNode;

        if (node.getLeft() != null) copyNode(node.getLeft(), newNode, false);
        if (node.getRight() != null) copyNode(node.getRight(), newNode, true);
    }

    public SplayTreeNode getRoot() {
        return root;
    }

    public String getInstruction() {
        return instruction;
    }
}
