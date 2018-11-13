package pl.edu.wat.wcy.isi.Operations;

import pl.edu.wat.wcy.isi.Model.SplayTreeNode;

class Rotate {

    public enum RotateType {LEFT, RIGHT}

    Rotate(SplayTreeNode node, RotateType type, SplayTreeNode root) {
        if (type == RotateType.LEFT) left(node, root);
        else right(node, root);
    }

    private void right(SplayTreeNode node, SplayTreeNode root) {
        SplayTreeNode leftChild =  node.getLeft();

        //If LeftChild is null we can't continue
        if (leftChild == null) return;

        SplayTreeNode father = node.getFather();

        //Set new left child from right left child
        node.setLeft(leftChild.getRight());

        //If new left child isn't null we set new father
        if (node.getLeft() != null)
            node.getLeft().setFather(node);

        //Set child as father
        leftChild.setRight(node);
        leftChild.setFather(father);
        node.setFather(leftChild);

        setFather(node, leftChild, father, root);
    }

    private void left (SplayTreeNode node, SplayTreeNode root) {
        SplayTreeNode rightChild = node.getRight();

        //If RightChild is null we can't continue
        if (rightChild == null) return;

        SplayTreeNode father = node.getFather();

        //set new right child from left right child
        node.setRight(rightChild.getLeft());

        //If new right child isn't null we set new father
        if (node.getRight() != null)
            node.getRight().setFather(node);

        //Set child sa father
        rightChild.setLeft(node);
        rightChild.setFather(father);
        node.setFather(rightChild);

        setFather(node, rightChild, father, root);
    }

    private void setFather(SplayTreeNode node, SplayTreeNode leftChild, SplayTreeNode father, SplayTreeNode root) {
        if(father != null) {
            if (father.getLeft() == node) father.setLeft(leftChild);
            else father.setRight(leftChild);
        }
        else SplayTreeNode.setRoot(leftChild);
    }
}
